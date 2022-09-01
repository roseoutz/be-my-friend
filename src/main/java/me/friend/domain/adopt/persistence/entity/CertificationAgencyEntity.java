package me.friend.domain.adopt.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import me.friend.domain.common.persistence.entity.TimeBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_certification_agency"
)
public class CertificationAgencyEntity extends TimeBaseEntity {

    @Id
    private String oid;

    private String name;

    private String mobileContact;

    private String homeContact;

    private String address;

    private String homepage;

    private String businessNumber;

}
