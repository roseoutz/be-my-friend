package me.friend.domain.adopt.persistence.entity;

import lombok.*;
import me.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_friend"
)
public class FriendEntity extends TimeBaseEntity {

    @Id
    private String oid;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = BreederEntity.class, fetch = FetchType.LAZY)
    private BreederEntity breeder;

    @OneToOne(targetEntity = FriendMedicalInfoEntity.class, fetch = FetchType.LAZY)
    private FriendMedicalInfoEntity medicalInfo;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime birthdate;

    private boolean adopted = false;

}
