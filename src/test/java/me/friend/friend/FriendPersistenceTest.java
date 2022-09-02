package me.friend.friend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.friend.domain.adopt.persistence.entity.FriendEntity;
import me.friend.domain.adopt.persistence.entity.QFriendEntity;
import me.friend.domain.adopt.persistence.repository.FriendRepository;
import me.friend.domain.common.dto.FriendDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(value = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FriendPersistenceTest extends AbstractFriendTest {

    @Autowired
    private FriendRepository repository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    @Transactional
    @DisplayName("반려동물 정보 Repository 저장 테스트")
    @Test
    void test_save() {

        // given
        FriendDTO friendDTO = getFriend();

        //when
        FriendEntity entity = toEntity(friendDTO);
        FriendEntity saved = repository.saveAndFlush(entity);

        // verify
        assertEquals(entity.getOid(), saved.getOid());
    }

    @Transactional
    @DisplayName("반려동물 정보 Repository 저장 오류 테스트")
    @Test
    void test_save_on_error() {

        // given
        FriendDTO friendDTO = getFriend();

        //when
        FriendEntity entity = new FriendEntity();
        entity.setOid(friendDTO.getOid());
        entity.setName(friendDTO.getName());
        entity.setType(friendDTO.getType());
        entity.setBirthdate(friendDTO.getBirthdate());
        entity.setAdopted(friendDTO.isAdopted());

        // verify
        assertThrows(DataIntegrityViolationException.class, () -> repository.saveAndFlush(entity));
    }

    @Transactional
    @DisplayName("반려동물 정보 Repository 조회 테스트")
    @Test
    void test_get() {

        // given
        FriendDTO friendDTO = getFriend();

        //when
        FriendEntity entity = toEntity(friendDTO);
        repository.saveAndFlush(entity);

        // verify
        String oid = friendDTO.getOid();
        Optional<FriendEntity> optional = repository.findById(oid);

        assertTrue(optional.isPresent());
        assertEquals(oid, optional.get().getOid());
    }

    @Transactional
    @DisplayName("반려동줄 정보 조회 by querysql")
    @Test
    void test_get_by_querydsl() {

        // given
        FriendDTO friendDTO = getFriend();


        //when
        FriendEntity entity = toEntity(friendDTO);
        repository.saveAndFlush(entity);
        QFriendEntity qFriendEntity = new QFriendEntity("f");

        //verify
        String oid = friendDTO.getOid();
        FriendEntity savedEntity = (FriendEntity) jpaQueryFactory.query().from(qFriendEntity)
                .where(qFriendEntity.oid.eq(oid))
                .fetchOne();

        assertNotNull(savedEntity);
        assertEquals(oid, savedEntity.getOid());
    }
}
