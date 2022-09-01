package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import me.friend.domain.common.persistence.entity.TimeBaseEntity;

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

    @ManyToOne(targetEntity = CertificationAgencyEntity.class, fetch = FetchType.LAZY)
    private CertificationAgencyEntity certificationAgency;

}
