package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.BreederEntity;
import be.friend.domain.adopt.persistence.repository.BreederRepository;
import be.friend.domain.adopt.persistence.service.BreederPersistenceService;
import be.friend.domain.common.dto.BreederDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("breederJpaService")
public class BreederJpaService
        extends AbstractPersistenceService<BreederRepository, BreederEntity, BreederDTO, String>
        implements BreederPersistenceService {

    @Autowired
    public BreederJpaService(BreederRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<BreederDTO> getDtoClass() {
        return BreederDTO.class;
    }

    @Override
    protected Class<BreederEntity> getEntityClass() {
        return BreederEntity.class;
    }

    @Override
    public BreederDTO add(BreederDTO dto) {
        return null;
    }

    @Override
    public BreederDTO update(BreederDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<BreederDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<BreederDTO> list(SearchParam searchParam) {
        return null;
    }
}
