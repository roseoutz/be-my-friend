package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.FriendVaccinationEntity;
import be.friend.domain.adopt.persistence.repository.FriendVaccinationRepository;
import be.friend.domain.adopt.persistence.service.FriendVaccinationPersistenceService;
import be.friend.domain.common.dto.FriendVaccinationDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendVaccinationJpaService
    extends AbstractPersistenceService<FriendVaccinationRepository, FriendVaccinationEntity, FriendVaccinationDTO, String>
    implements FriendVaccinationPersistenceService {

    public FriendVaccinationJpaService(FriendVaccinationRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<FriendVaccinationDTO> getDtoClass() {
        return FriendVaccinationDTO.class;
    }

    @Override
    protected Class<FriendVaccinationEntity> getEntityClass() {
        return FriendVaccinationEntity.class;
    }

    @Override
    public FriendVaccinationDTO add(FriendVaccinationDTO dto) {
        return null;
    }

    @Override
    public FriendVaccinationDTO update(FriendVaccinationDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<FriendVaccinationDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<FriendVaccinationDTO> list(SearchParam searchParam) {
        return null;
    }
}
