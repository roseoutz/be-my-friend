package be.friend.domain.adopt.persistence.entity;

import lombok.*;
import be.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breeder")
    private BreederEntity breeder;

    @OneToOne(fetch = FetchType.LAZY)
    private FriendMedicalInfoEntity medicalInfo;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDate birthdate;

    private boolean adopted = false;

}
