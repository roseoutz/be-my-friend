package me.friend.base.repository;

import me.friend.common.util.StringCheckUtil;
import me.friend.common.util.UUIDUtil;
import me.friend.domain.adopt.persistence.entity.BreederEntity;
import me.friend.domain.adopt.persistence.repository.BreederRepository;

import java.util.Optional;

public abstract class AbstractBreederTest extends AbstractBreederCertificationTest {

    protected abstract BreederRepository getBreederRepository();

    protected Optional<BreederEntity> breederGet(String oid) {
        if (StringCheckUtil.isNull(oid)) {
            return Optional.empty();
        }

        return getBreederRepository().findById(oid);
    }

    protected BreederEntity breederSave(BreederEntity entity) {
        return getBreederRepository().saveAndFlush(entity);
    }

    protected BreederEntity getBreederEntity() {
        BreederEntity entity = new BreederEntity();

        entity.setOid(UUIDUtil.UUID());
        entity.setName("홍길동");
        entity.setAddress("경기도 용인시 수지구");
        entity.setHomeContact("031-123-123");
        entity.setImageUrl("http://www.naver.com");
        entity.setMobileContact("010-1234-1234");
        entity.setSnsAddress("https://instagram.com");

        return entity;
    }
}
