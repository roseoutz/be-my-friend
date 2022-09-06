package be.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_breeder_certification"
)
public class BreederCertificationEntity {

    @Id
    private String oid;

    private String certificationNumber;

    private LocalDate acquisitionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_type")
    private CertificationTypeEntity certificationTypeEntity;

}
