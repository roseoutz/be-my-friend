package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.FriendEntity;
import be.friend.domain.adopt.persistence.repository.FriendRepository;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.exception.ErrorCode;
import be.friend.domain.common.exception.FriendNotFoundException;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import be.friend.domain.adopt.persistence.service.FriendPersistenceService;
import be.friend.domain.common.dto.FriendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("friendJpaService")
public class FriendJpaService
        extends AbstractPersistenceService <FriendRepository, FriendEntity, FriendDTO, String>
        implements FriendPersistenceService {

    @Autowired
    public FriendJpaService(FriendRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<FriendDTO> getDtoClass() {
        return FriendDTO.class;
    }

    @Override
    protected Class<FriendEntity> getEntityClass() {
        return FriendEntity.class;
    }

    @Override
    @Transactional
    public FriendDTO add(FriendDTO dto) {
        FriendEntity saved = getRepository().save(convertToEntity(dto));
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public FriendDTO update(FriendDTO dto) {

        Optional<FriendEntity> optional = getRepository().findById(dto.getOid());

        if (optional.isEmpty()) {
            throw new FriendNotFoundException(ErrorCode.FRIEND_NOT_FOUND);
        }

        FriendEntity entity = optional.get();

        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public void delete(String oid) {
        Optional.of(oid)
                .ifPresent(id -> getRepository().deleteById(id));
    }

    @Override
    public Optional<FriendDTO> get(String oid) {
        return getRepository().findById(oid)
                .map(this::convertToDTO);
    }

    public List<FriendDTO> list(SearchParam searchParam) {
        return null;
    }



}
