package be.friend.adopt;

import be.friend.common.util.UUIDUtil;
import be.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import be.friend.domain.adopt.persistence.entity.BreederEntity;
import be.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import be.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import be.friend.domain.adopt.persistence.repository.BreederCertificationRepository;
import be.friend.domain.adopt.persistence.repository.BreederRepository;
import be.friend.domain.adopt.persistence.repository.CertificationTypeRepository;
import be.friend.base.repository.BreederCertificationTestService;
import be.friend.base.repository.BreederTestService;
import be.friend.base.repository.CertificationAgencyTestService;
import be.friend.base.repository.CertificationTypeTestService;
import be.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("브리더 인증 자격증 및 인증 기관 테스트")
@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BreederCertificationPersistenceTest {

    private final CertificationAgencyTestService certificationAgencyTestService;

    private final CertificationTypeTestService certificationTypeTestService;

    private final BreederCertificationTestService breederCertificationTestService;

    private final BreederTestService breederTestService;

    @Autowired
    public BreederCertificationPersistenceTest(
            CertificationAgencyRepository certificationAgencyRepository,
            CertificationTypeRepository certificationTypeRepository,
            BreederCertificationRepository breederCertificationRepository,
            BreederRepository breederRepository) {

        this.certificationTypeTestService = new CertificationTypeTestService(certificationTypeRepository);
        this.certificationAgencyTestService = new CertificationAgencyTestService(certificationAgencyRepository);
        this.breederCertificationTestService = new BreederCertificationTestService(breederCertificationRepository);
        this.breederTestService = new BreederTestService(breederRepository);
    }

    private CertificationAgencyEntity getAgencyEntity() {
        CertificationAgencyEntity entity = new CertificationAgencyEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setName("한국 애견 협회");
        entity.setAddress("경기도 성남시 분당구");
        entity.setBusinessNumber("00-00000-00000");
        entity.setHomeContact("031-0000-0000");
        entity.setMobileContact("010-0000-0000");
        entity.setHomepage("https://petmanageracademy2.com/");

        return entity;
    }

    private CertificationTypeEntity getTypeEntity() {
        CertificationTypeEntity entity = new CertificationTypeEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setCertificationType("반려동물관리사");
        entity.setDescription("반려동물 관련 지식");

        return entity;
    }

    private BreederCertificationEntity getBreederCertificationEntity() {
        BreederCertificationEntity entity = new BreederCertificationEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setCertificationNumber("00-000000000");
        entity.setAcquisitionDate(LocalDate.of(2020, 1, 1));

        return entity;
    }

    private BreederEntity getBreederEntity() {
        BreederEntity entity = new BreederEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setName("홍길동");
        entity.setAddress("경기도 양평시");
        entity.setHomeContact("031-0000-0001");
        entity.setMobileContact("010-0000-0001");

        return entity;
    }

    @DisplayName("브리더 인증 기관 등록 테스트")
    @Transactional
    @Test
    void test_save_certification_agency() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();

        //when
        certificationAgencyTestService.save(entity);

        //verify
        certificationAgencyTestService.findById(entity.getOid())
                .ifPresentOrElse(
                        saved -> assertEquals(entity.getOid(), saved.getOid()),
                        Assertions::fail
                );
    }

    @DisplayName("브리더 인증 기관 수정 테스트")
    @Transactional
    @Test
    void test_update_certification_agency() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();
        CertificationAgencyEntity saved = certificationAgencyTestService.save(entity);

        //when
        saved.setAddress("충청남도");
        certificationAgencyTestService.save(saved);

        //verify
        certificationAgencyTestService.findById(entity.getOid())
                .ifPresentOrElse(
                        e -> {
                            assertEquals("충청남도", e.getAddress());
                            assertTrue(e.getUpdateTime().isAfter(e.getInsertTime()));
                        },
                        Assertions::fail
        );
    }

    @DisplayName("브리더 인증 기관 삭제 테스트")
    @Transactional
    @Test
    void test_delete_certification_agency() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();
        String oid = entity.getOid();
        certificationAgencyTestService.save(entity);

        //when
        certificationAgencyTestService.deleteById(oid);

        //verify
        certificationAgencyTestService.findById(oid)
                .ifPresentOrElse(
                        saved -> fail(),
                        () -> assertTrue(true)
                );
    }

    @DisplayName("브리더 인증 기관 자격증 등록 테스트")
    @Transactional
    @Test
    void test_save_certification_type() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();
        certificationAgencyTestService.save(entity);
        CertificationTypeEntity typeEntity = getTypeEntity();

        //when
        typeEntity.setCertificationAgency(entity);
        final String oid = typeEntity.getOid();
        certificationTypeTestService.save(typeEntity);

        //verify
        certificationTypeTestService.findById(oid)
                .ifPresentOrElse(
                        saved -> assertEquals(oid, saved.getOid()),
                        Assertions::fail
                );
    }

    @DisplayName("브리더 인증 기관 자격증 수정 테스트")
    @Transactional
    @Test
    void test_update_certification_type() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();
        certificationAgencyTestService.save(entity);
        CertificationTypeEntity typeEntity = getTypeEntity();
        typeEntity.setCertificationAgency(entity);
        final String oid = typeEntity.getOid();
        CertificationTypeEntity saved = certificationTypeTestService.save(typeEntity);

        //when
        saved.setDescription("modified");
        certificationTypeTestService.save(saved);

        //verify
        certificationTypeTestService.findById(oid)
                .ifPresentOrElse(
                        e -> {
                            assertEquals("modified", e.getDescription());
                            assertTrue(e.getUpdateTime().isAfter(e.getInsertTime()));
                        },
                        Assertions::fail
                );
    }

    @DisplayName("브리더 인증 기관 자격증 삭제 테스트")
    @Transactional
    @Test
    void test_delete_certification_type() {
        //given
        CertificationAgencyEntity entity = getAgencyEntity();
        certificationAgencyTestService.save(entity);
        CertificationTypeEntity typeEntity = getTypeEntity();
        typeEntity.setCertificationAgency(entity);
        final String oid = typeEntity.getOid();
        certificationTypeTestService.save(typeEntity);

        //when
        certificationTypeTestService.deleteById(oid);

        //verify
        certificationTypeTestService.findById(oid)
                .ifPresentOrElse(
                        e -> fail(),
                        () -> assertTrue(true)
                );
    }

    @DisplayName("브리더 등록 테스트")
    @Transactional
    @Test
    void test_save_breeder() {
        //given
        BreederEntity entity = getBreederEntity();
        final String oid = entity.getOid();

        //when
        breederTestService.save(entity);

        //verify
        breederTestService.findById(oid)
                .ifPresentOrElse(
                        e -> assertEquals(oid, e.getOid()),
                        Assertions::fail
                );
    }

    @DisplayName("브리더 수정 테스트")
    @Transactional
    @Test
    void test_update_breeder() {
        //given
        BreederEntity entity = getBreederEntity();
        BreederEntity saved = breederTestService.save(entity);
        final String oid = saved.getOid();

        //when
        saved.setName("우주인");
        breederTestService.save(saved);

        //verify
        breederTestService.findById(oid)
                .ifPresentOrElse(
                        e -> assertEquals("우주인", e.getName()),
                        Assertions::fail
                );
    }

    @DisplayName("브리더 삭제 테스트")
    @Transactional
    @Test
    void test_delete_breeder() {
        //given
        BreederEntity entity = getBreederEntity();
        BreederEntity saved = breederTestService.save(entity);
        final String oid = saved.getOid();

        //when
        breederTestService.deleteById(oid);

        //verify
        breederTestService.findById(oid)
                .ifPresentOrElse(
                        e -> fail(),
                        () -> assertTrue(true)

                );
    }

    @DisplayName("브리더 취득 자격증 등록 테스트")
    @Transactional
    @Test
    void test_save_breeder_certification() {

    }

    @DisplayName("브리더 취득 자격증 수정 테스트")
    @Transactional
    @Test
    void test_update_breeder_certification() {

    }

    @DisplayName("브리더 취득 자격증 삭제 테스트")
    @Transactional
    @Test
    void test_delete_breeder_certification() {

    }


}
