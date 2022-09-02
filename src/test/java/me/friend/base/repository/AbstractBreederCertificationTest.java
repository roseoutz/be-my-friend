package me.friend.base.repository;

import me.friend.common.util.StringCheckUtil;
import me.friend.common.util.UUIDUtil;
import me.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import me.friend.domain.adopt.persistence.repository.BreederCertificationRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class AbstractBreederCertificationTest extends AbstractCertificationTypeTest {

    protected abstract BreederCertificationRepository getBreederCertificationRepository();

    protected Optional<BreederCertificationEntity> breederCertificationGet(String oid) {
        if (StringCheckUtil.isNull(oid))
            return Optional.empty();

        return getBreederCertificationRepository().findById(oid);
    }

    protected BreederCertificationEntity breederCertificationSave(BreederCertificationEntity entity) {
        return getBreederCertificationRepository().saveAndFlush(entity);
    }

    protected BreederCertificationEntity getBreederCertificationEntity() {
        BreederCertificationEntity entity = new BreederCertificationEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setCertificationNumber("00000000");
        entity.setAcquisitionDate(LocalDateTime.now());

        return entity;
    }
}
