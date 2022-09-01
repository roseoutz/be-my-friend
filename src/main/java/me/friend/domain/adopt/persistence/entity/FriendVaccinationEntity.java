package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    private VaccineInfoEntity vaccinInfoEntity;

    private int vaccinationCount;

    private LocalDateTime lastVaccinationDate;

}
