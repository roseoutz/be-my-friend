package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import me.friend.domain.common.persistence.entity.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_certification"
)
public class CertificationEntity extends BaseEntity {

    @Id
    private String oid;

    private String certificationType;

    private String description;

    @ManyToOne(targetEntity = CertificationAgencyEntity.class, fetch = FetchType.LAZY)
    private CertificationAgencyEntity certificationAgency;

}
