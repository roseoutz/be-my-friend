package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_friend_vaccination"
)
public class FriendVaccinationEntity {

    @Id
    private String oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_info")
    private VaccineInfoEntity vaccineInfoEntity;

    private int vaccinationCount;

    private LocalDate lastVaccinationDate;

}
