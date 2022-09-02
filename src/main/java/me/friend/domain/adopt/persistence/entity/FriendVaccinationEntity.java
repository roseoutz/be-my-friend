package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_friend_vaccination"
)
public class FriendVaccinationEntity {

    @Id
    private String oid;

    @ManyToOne(targetEntity = VaccineInfoEntity.class, fetch = FetchType.LAZY)
    private VaccineInfoEntity vaccineInfoEntity;

    private int vaccinationCount;

    private LocalDateTime lastVaccinationDate;

}
