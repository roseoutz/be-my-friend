package me.friend.breeder;

import me.friend.base.repository.AbstractBreederTest;
import me.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import me.friend.domain.adopt.persistence.entity.BreederEntity;
import me.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import me.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import me.friend.domain.adopt.persistence.repository.BreederCertificationRepository;
import me.friend.domain.adopt.persistence.repository.BreederRepository;
import me.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;
import me.friend.domain.adopt.persistence.repository.CertificationTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BreederPersistenceTest extends AbstractBreederTest {

    @Autowired
    CertificationAgencyRepository certificationAgencyRepository;

    @Autowired
    CertificationTypeRepository certificationTypeRepository;

    @Autowired
    BreederCertificationRepository breederCertificationRepository;

    @Autowired
    BreederRepository breederRepository;

    @Override
    protected BreederCertificationRepository getBreederCertificationRepository() {
        return breederCertificationRepository;
    }

    @Override
    protected BreederRepository getBreederRepository() {
        return breederRepository;
    }

    @Override
    protected CertificationAgencyRepository getCertificationAgencyRepository() {
        return certificationAgencyRepository;
    }

    @Override
    protected CertificationTypeRepository getCertificationTypeRepository() {
        return certificationTypeRepository;
    }

    @Transactional
    @Test
    void test_breeder_save() {
        // given
        CertificationAgencyEntity certificationAgencyEntity = certificationAgencyEntitySave(getAgencyEntity());

        CertificationTypeEntity certificationTypeEntity = getTypeEntity();
        certificationTypeEntity.setCertificationAgency(certificationAgencyEntity);
        certificationTypeSave(certificationTypeEntity);

        BreederCertificationEntity breederCertificationEntity = getBreederCertificationEntity();
        breederCertificationEntity.setCertificationTypeEntity(certificationTypeEntity);
        breederCertificationSave(breederCertificationEntity);

        BreederEntity breeder = getBreederEntity();
        breeder.setCertificationEntities(List.of(breederCertificationEntity));

        // when
        BreederEntity saved = breederSave(breeder);

        //verify
        assertEquals(breeder.getOid(), saved.getOid());
        assertEquals(breederCertificationEntity.getOid(), saved.getCertificationEntities().get(0).getOid());

    }

    @Transactional
    @Test
    void test_breeder_get() {
        // given
        CertificationAgencyEntity certificationAgencyEntity = certificationAgencyEntitySave(getAgencyEntity());

        CertificationTypeEntity certificationTypeEntity = getTypeEntity();
        certificationTypeEntity.setCertificationAgency(certificationAgencyEntity);
        certificationTypeSave(certificationTypeEntity);

        BreederCertificationEntity breederCertificationEntity = getBreederCertificationEntity();
        breederCertificationEntity.setCertificationTypeEntity(certificationTypeEntity);
        breederCertificationSave(breederCertificationEntity);

        BreederEntity breeder = getBreederEntity();
        breeder.setCertificationEntities(List.of(breederCertificationEntity));
        breederSave(breeder);

        Optional<BreederEntity> optional = getBreederRepository().findById(breeder.getOid());

        assertFalse(optional.isEmpty());
        assertEquals(breeder.getOid(), optional.get().getOid());

    }
}
