package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import be.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_certification_type"
)
public class CertificationTypeEntity extends TimeBaseEntity {

    @Id
    private String oid;

    private String certificationType;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_agency")
    private CertificationAgencyEntity certificationAgency;

}
