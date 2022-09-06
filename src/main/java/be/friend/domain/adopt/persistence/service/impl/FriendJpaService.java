package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.FriendEntity;
import be.friend.domain.adopt.persistence.repository.FriendRepository;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import be.friend.domain.adopt.persistence.service.FriendPersistenceService;
import be.friend.domain.common.dto.FriendDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("friendJpaService")
@RequiredArgsConstructor
public class FriendJpaService implements FriendPersistenceService {

    private final JPAQueryFactory jpaQueryFactory;

    private final FriendRepository friendRepository;

    private final ObjectMapper objectMapper;

    private FriendRepository getRepository() {
        return friendRepository;
    }

    private JPAQueryFactory getQueryFactory() {
        return jpaQueryFactory;
    }

    private FriendDTO convertToDTO(FriendEntity entity) {
        return objectMapper.convertValue(entity, FriendDTO.class);
    }

    private FriendEntity convertToEntity(FriendDTO dto) {
        return objectMapper.convertValue(dto, FriendEntity.class);
    }

    @Override
    @Transactional
    public FriendDTO add(FriendDTO dto) {
        return null;
    }

    @Override
    @Transactional
    public FriendDTO update(FriendDTO dto) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String oid) {
        getRepository().deleteById(oid);
    }

    @Override
    public Optional<FriendDTO> get(String oid) {
        return Optional.empty();
    }

    public List<FriendDTO> list(SearchParam searchParam) {
        return null;
    }



}
