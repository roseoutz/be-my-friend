package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_vaccine_info"
)
public class VaccineInfoEntity {

    @Id
    private String oid;

    private String name;

    private String description;

    private String priority;

    private int vaccinationCount;
}
