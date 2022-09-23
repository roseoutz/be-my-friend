package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.ManagerEntity;
import be.friend.domain.adopt.persistence.repository.ManagerRepository;
import be.friend.domain.adopt.persistence.service.ManagerPersistenceService;
import be.friend.domain.common.dto.ManagerDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("managerJpaService")
public class ManagerJpaService
    extends AbstractPersistenceService<ManagerRepository, ManagerEntity, ManagerDTO, String>
    implements ManagerPersistenceService {

    public ManagerJpaService(ManagerRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<ManagerDTO> getDtoClass() {
        return ManagerDTO.class;
    }

    @Override
    protected Class<ManagerEntity> getEntityClass() {
        return ManagerEntity.class;
    }

    @Override
    public ManagerDTO add(ManagerDTO dto) {
        return null;
    }

    @Override
    public ManagerDTO update(ManagerDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<ManagerDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<ManagerDTO> list(SearchParam searchParam) {
        return null;
    }
}
