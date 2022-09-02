package me.friend.base.repository;

import me.friend.common.util.StringCheckUtil;
import me.friend.common.util.UUIDUtil;
import me.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import me.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;

import java.util.Optional;

public abstract class AbstractCertificationAgencyTest {

    protected abstract CertificationAgencyRepository getCertificationAgencyRepository();

    protected CertificationAgencyEntity certificationAgencyEntitySave(CertificationAgencyEntity entity) {
        return getCertificationAgencyRepository().saveAndFlush(entity);
    }

    protected Optional<CertificationAgencyEntity> certificationAgencyGet(String oid) {

        if (StringCheckUtil.isNull(oid)) {
            return Optional.empty();
        }

        return getCertificationAgencyRepository().findById(oid);
    }

    protected CertificationAgencyEntity getAgencyEntity() {
        CertificationAgencyEntity certificationAgency = new CertificationAgencyEntity();

        certificationAgency.setOid(UUIDUtil.UUID());
        certificationAgency.setName("한국반려동물협회");
        certificationAgency.setAddress("경기도 성남시 분당구 야탑동");
        certificationAgency.setHomepage("http://www.naver.com");
        certificationAgency.setHomeContact("031-1111-1111");
        certificationAgency.setMobileContact("010-4123-1234");
        certificationAgency.setBusinessNumber("12-542-123421");

        return certificationAgency;
    }
}
