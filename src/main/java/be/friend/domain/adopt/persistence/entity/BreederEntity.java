package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import be.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_breeder"
)
public class BreederEntity extends TimeBaseEntity {

    @Id
    private String oid;

    private String name;

    private String mobileContact;

    private String homeContact;

    private String address;

    private String snsAddress;

    private String imageUrl;

    @OneToMany(mappedBy = "oid")
    private List<BreederCertificationEntity> certificationEntities;

    @OneToMany(mappedBy = "oid", cascade = CascadeType.REMOVE)
    private List<FriendEntity> friends;

    @ManyToOne(targetEntity = ManagerEntity.class, fetch = FetchType.LAZY)
    private ManagerEntity manager;

}
