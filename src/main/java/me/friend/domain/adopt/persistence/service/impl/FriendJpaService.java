package me.friend.domain.adopt.persistence.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.friend.domain.adopt.persistence.entity.FriendEntity;
import me.friend.domain.adopt.persistence.repository.FriendRepository;
import me.friend.domain.adopt.persistence.service.FriendPersistenceService;
import me.friend.domain.common.dto.FriendDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("friendJpaService")
@RequiredArgsConstructor
public class FriendJpaService implements FriendPersistenceService {

    private final JPAQueryFactory jpaQueryFactory;

    private final FriendRepository friendRepository;

    @Transactional
    @Override
    public FriendDTO add(FriendEntity friendDTO) {
        return null;
    }

    @Transactional
    @Override
    public FriendDTO update(FriendEntity friendDTO) {
        return null;
    }

    @Transactional
    @Override
    public void delete(String oid) {

    }

    @Override
    public FriendDTO get(String oid) {
        return null;
    }

    @Override
    public List<FriendDTO> list() {
        return null;
    }
}
