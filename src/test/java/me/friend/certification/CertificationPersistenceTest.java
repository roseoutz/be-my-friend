package me.friend.certification;

import me.friend.base.repository.AbstractCertificationTypeTest;
import me.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import me.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import me.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;
import me.friend.domain.adopt.persistence.repository.CertificationTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CertificationPersistenceTest extends AbstractCertificationTypeTest {

    @Autowired
    CertificationAgencyRepository certificationAgencyRepository;

    @Autowired
    CertificationTypeRepository certificationTypeRepository;

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
    void test_certification_agency_save() {
        // given
        CertificationAgencyEntity entity = getAgencyEntity();

        //when
        CertificationAgencyEntity saved = certificationAgencyEntitySave(entity);

        //verify
        assertEquals(entity.getOid(), saved.getOid());
    }

    @Transactional
    @Test
    void test_certification_type_save() {
        // given
        CertificationAgencyEntity agencyEntity = getAgencyEntity();
        CertificationAgencyEntity savedAgency = certificationAgencyEntitySave(agencyEntity);
        CertificationTypeEntity entity = getTypeEntity();
        entity.setCertificationAgency(savedAgency);
        //when


        // when
        CertificationTypeEntity saved = certificationTypeSave(entity);

        // verify
        assertEquals(entity.getOid(), saved.getOid());
        assertEquals(entity.getCertificationAgency().getOid(), saved.getCertificationAgency().getOid());

    }

    @Transactional
    @Test
    void test_certification_type_get() {
        // given
        CertificationAgencyEntity agencyEntity = getAgencyEntity();
        CertificationAgencyEntity savedAgency = certificationAgencyEntitySave(agencyEntity);
        CertificationTypeEntity entity = getTypeEntity();
        entity.setCertificationAgency(savedAgency);
        certificationTypeSave(entity);

        //when
        Optional<CertificationTypeEntity> optional = certificationTypeGet(entity.getOid());

        // when
        assertFalse(optional.isEmpty());
        CertificationTypeEntity findOne = optional.get();
        assertEquals(findOne.getOid(), entity.getOid());
        assertEquals(findOne.getCertificationAgency().getOid(), entity.getCertificationAgency().getOid());
    }


}
