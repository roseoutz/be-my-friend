package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_friend_medical_info"
)
public class FriendMedicalInfoEntity {

    @Id
    private String oid;

    @OneToMany
    private List<FriendVaccinationEntity> vaccinationEntities;
}
