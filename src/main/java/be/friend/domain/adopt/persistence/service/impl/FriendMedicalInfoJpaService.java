package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.FriendMedicalInfoEntity;
import be.friend.domain.adopt.persistence.repository.FriendMedicalInfoRepository;
import be.friend.domain.adopt.persistence.service.FriendMedicalInfoPersistenceService;
import be.friend.domain.common.dto.FriendMedicalInfoDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendMedicalInfoJpaService
    extends AbstractPersistenceService<FriendMedicalInfoRepository, FriendMedicalInfoEntity, FriendMedicalInfoDTO, String>
    implements FriendMedicalInfoPersistenceService {

    public FriendMedicalInfoJpaService(FriendMedicalInfoRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<FriendMedicalInfoDTO> getDtoClass() {
        return FriendMedicalInfoDTO.class;
    }

    @Override
    protected Class<FriendMedicalInfoEntity> getEntityClass() {
        return FriendMedicalInfoEntity.class;
    }

    @Override
    public FriendMedicalInfoDTO add(FriendMedicalInfoDTO dto) {
        return null;
    }

    @Override
    public FriendMedicalInfoDTO update(FriendMedicalInfoDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<FriendMedicalInfoDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<FriendMedicalInfoDTO> list(SearchParam searchParam) {
        return null;
    }
}
