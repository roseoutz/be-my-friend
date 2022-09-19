package be.friend.adopt;

import be.friend.base.repository.*;
import be.friend.common.util.UUIDUtil;
import be.friend.domain.adopt.persistence.entity.*;
import be.friend.domain.adopt.persistence.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("반려동물 상세 정보 및 브리더 테스트")
@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FriendBreederPersistenceTest {

    private final FriendTestService friendTestService;
    private final FriendMeicalInfoTestService friendMeicalInfoTestService;
    private final FriendVaccinationTestService friendVaccinationTestService;
    private final VaccineInfoTestService vaccineInfoTestService;
    private final BreederTestService breederTestService;

    @Autowired
    public FriendBreederPersistenceTest(
            FriendRepository friendRepository,
            FriendMedicalInfoRepository friendMedicalInfoRepository,
            FriendVaccinationRepository friendVaccinationRepository,
            VaccineInfoRepository vaccineInfoRepository,
            BreederRepository breederRepository
    ) {
        this.friendTestService = new FriendTestService(friendRepository);
        this.friendMeicalInfoTestService = new FriendMeicalInfoTestService(friendMedicalInfoRepository);
        this.friendVaccinationTestService = new FriendVaccinationTestService(friendVaccinationRepository);
        this.vaccineInfoTestService = new VaccineInfoTestService(vaccineInfoRepository);
        this.breederTestService = new BreederTestService(breederRepository);
    }

    private FriendEntity getFriendEntity() {
        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setOid(UUIDUtil.UUID());
        friendEntity.setName("Cobi");
        friendEntity.setBreed("Welsh Corgi");
        friendEntity.setAdopted(false);
        friendEntity.setBirthdate(LocalDate.now());
        friendEntity.setType("DOG");

        return friendEntity;
    }

    private FriendMedicalInfoEntity getFriendMedicalInfoEntity() {
        FriendMedicalInfoEntity entity = new FriendMedicalInfoEntity();
        entity.setOid(UUIDUtil.UUID());

        return entity;
    }

    private FriendVaccinationEntity getFriendVaccinationEntity() {
        FriendVaccinationEntity entity = new FriendVaccinationEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setVaccinationCount(3);
        entity.setLastVaccinationDate(LocalDate.now());

        return entity;
    }

    private VaccineInfoEntity getVaccineInfoEntity() {
        VaccineInfoEntity entity = new VaccineInfoEntity();
        entity.setOid(UUIDUtil.UUID());
        entity.setVaccinationCount(5);
        entity.setName("광견병 예방 주사");
        entity.setPriority("High");

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

    @Transactional
    @DisplayName("백신 정보 저장 테스트")
    @Test
    void test_save_vaccine_info() {
        // given
        VaccineInfoEntity entity = getVaccineInfoEntity();

        // when
        vaccineInfoTestService.save(entity);

        // verify
        vaccineInfoTestService.findById(entity.getOid())
                .ifPresentOrElse(
                        saved -> assertEquals(entity.getOid(), saved.getOid()),
                        Assertions::fail
                );
    }

    @Transactional
    @DisplayName("백신 정보 수정 테스트")
    @Test
    void test_update_vaccine_info() {
        // given
        VaccineInfoEntity entity = getVaccineInfoEntity();
        VaccineInfoEntity savedEntity = vaccineInfoTestService.save(entity);

        // when
        savedEntity.setVaccinationCount(10);
        vaccineInfoTestService.save(savedEntity);

        // verify
        vaccineInfoTestService.findById(savedEntity.getOid())
                .ifPresentOrElse(
                        saved -> assertEquals(10, saved.getVaccinationCount()),
                        Assertions::fail
                );
    }

    @Transactional
    @DisplayName("백신 정뷰 삭제 테스트")
    @Test
    void test_delete_vaccine_info() {
        // given
        VaccineInfoEntity entity = getVaccineInfoEntity();
        vaccineInfoTestService.save(entity);
        final String oid = entity.getOid();

        // when
        vaccineInfoTestService.delete(entity);

        // verify
        vaccineInfoTestService.findById(oid)
                .ifPresentOrElse(
                        e -> fail(),
                        () -> assertTrue(true)
                );
    }

    @Transactional
    @DisplayName("반려동물 및 백신 접종 내역 저장 테스트")
    @Test
    void test_save_friend_vaccination() {
        // given
        VaccineInfoEntity vaccineInfoEntity = getVaccineInfoEntity();
        vaccineInfoTestService.save(vaccineInfoEntity);

        FriendVaccinationEntity friendVaccinationEntity = getFriendVaccinationEntity();
        friendVaccinationEntity.setVaccineInfoEntity(vaccineInfoEntity);
        friendVaccinationTestService.save(friendVaccinationEntity);

        FriendMedicalInfoEntity friendMedicalInfoEntity = getFriendMedicalInfoEntity();
        friendMedicalInfoEntity.setVaccinationEntities(List.of(friendVaccinationEntity));
        friendMeicalInfoTestService.save(friendMedicalInfoEntity);

        FriendEntity friendEntity = getFriendEntity();
        friendEntity.setMedicalInfo(friendMedicalInfoEntity);

        // when
        friendTestService.save(friendEntity);

        // verify
        friendTestService.findById(friendEntity.getOid())
                .ifPresentOrElse(
                        saved -> assertEquals(friendEntity.getOid(), saved.getOid()),
                        Assertions::fail
                );

    }

    @Transactional
    @DisplayName("반려동물 및 백신 접종 내역 수정 테스트")
    @Test
    void test_update_friend_vaccination() {
        // given
        VaccineInfoEntity vaccineInfoEntity = getVaccineInfoEntity();
        vaccineInfoTestService.save(vaccineInfoEntity);

        FriendVaccinationEntity friendVaccinationEntity = getFriendVaccinationEntity();
        friendVaccinationEntity.setVaccineInfoEntity(vaccineInfoEntity);
        friendVaccinationTestService.save(friendVaccinationEntity);

        FriendMedicalInfoEntity friendMedicalInfoEntity = getFriendMedicalInfoEntity();
        friendMedicalInfoEntity.setVaccinationEntities(List.of(friendVaccinationEntity));
        friendMeicalInfoTestService.save(friendMedicalInfoEntity);

        FriendEntity friendEntity = getFriendEntity();
        friendEntity.setMedicalInfo(friendMedicalInfoEntity);
        FriendEntity savedEntity = friendTestService.save(friendEntity);

        // when
        savedEntity.setType("CAT");
        friendTestService.save(savedEntity);

        // verify
        friendTestService.findById(savedEntity.getOid())
                .ifPresentOrElse(
                        saved -> assertEquals("CAT", saved.getType()),
                        Assertions::fail
                );
    }

    @Transactional
    @DisplayName("반려동물 및 백신 접종 내역 삭제 테스트")
    @Test
    void test_delete_friend_vaccination() {
        // given
        VaccineInfoEntity vaccineInfoEntity = getVaccineInfoEntity();
        vaccineInfoTestService.save(vaccineInfoEntity);

        FriendVaccinationEntity friendVaccinationEntity = getFriendVaccinationEntity();
        friendVaccinationEntity.setVaccineInfoEntity(vaccineInfoEntity);
        friendVaccinationTestService.save(friendVaccinationEntity);

        FriendMedicalInfoEntity friendMedicalInfoEntity = getFriendMedicalInfoEntity();
        friendMedicalInfoEntity.setVaccinationEntities(List.of(friendVaccinationEntity));
        friendMeicalInfoTestService.save(friendMedicalInfoEntity);

        FriendEntity friendEntity = getFriendEntity();
        friendEntity.setMedicalInfo(friendMedicalInfoEntity);
        FriendEntity savedEntity = friendTestService.save(friendEntity);
        final String oid = savedEntity.getOid();

        // when
        friendTestService.delete(savedEntity);

        // verify
        friendTestService.findById(oid)
                .ifPresentOrElse(
                        e -> fail(),
                        () -> assertTrue(true)
                );
    }
}
