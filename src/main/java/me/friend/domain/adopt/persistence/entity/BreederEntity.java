package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import me.friend.domain.common.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_breeder"
)
public class BreederEntity extends BaseEntity {

    @Id
    private String oid;

    private String name;

    private String mobileContact;

    private String homeContact;

    private String address;

    private String certificationNumber;

    private String snsAddress;

    private String imageUrl;

    @OneToMany(mappedBy = "friends", cascade = CascadeType.REMOVE)
    private List<FriendEntity> friends;

    @ManyToOne(targetEntity = ManagerEntity.class, fetch = FetchType.LAZY)
    private ManagerEntity manager;

}
