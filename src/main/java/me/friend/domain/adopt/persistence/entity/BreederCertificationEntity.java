package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime acquisitionDate;

    @ManyToOne(targetEntity = CertificationTypeEntity.class, fetch = FetchType.LAZY)
    private CertificationTypeEntity certificationTypeEntity;

}
