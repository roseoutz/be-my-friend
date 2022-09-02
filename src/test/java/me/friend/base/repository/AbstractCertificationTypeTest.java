package me.friend.base.repository;

import me.friend.common.util.StringCheckUtil;
import me.friend.common.util.UUIDUtil;
import me.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import me.friend.domain.adopt.persistence.repository.CertificationTypeRepository;

import java.util.Optional;

public abstract class AbstractCertificationTypeTest extends AbstractCertificationAgencyTest {

    protected abstract CertificationTypeRepository getCertificationTypeRepository();

    protected CertificationTypeEntity certificationTypeSave(CertificationTypeEntity entity) {
        return getCertificationTypeRepository().saveAndFlush(entity);
    }

    protected Optional<CertificationTypeEntity> certificationTypeGet(String oid) {
        if (StringCheckUtil.isNull(oid)) {
            return Optional.empty();
        }

        return getCertificationTypeRepository().findById(oid);
    }

    protected CertificationTypeEntity getTypeEntity() {
        CertificationTypeEntity entity = new CertificationTypeEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setDescription("반려동물 자격증");
        entity.setCertificationType("반려동물 자격증");

        return entity;
    }
}
