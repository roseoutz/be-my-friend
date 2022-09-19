package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import be.friend.domain.adopt.persistence.repository.BreederCertificationRepository;
import be.friend.domain.adopt.persistence.service.BreederCertificationPersistenceService;
import be.friend.domain.common.dto.BreederCertificationDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreederCertificationJpaService
        extends AbstractPersistenceService<BreederCertificationRepository, BreederCertificationEntity, BreederCertificationDTO, String>
        implements BreederCertificationPersistenceService {
    public BreederCertificationJpaService(BreederCertificationRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<BreederCertificationDTO> getDtoClass() {
        return BreederCertificationDTO.class;
    }

    @Override
    protected Class<BreederCertificationEntity> getEntityClass() {
        return BreederCertificationEntity.class;
    }

    @Override
    public BreederCertificationDTO add(BreederCertificationDTO dto) {
        return null;
    }

    @Override
    public BreederCertificationDTO update(BreederCertificationDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<BreederCertificationDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<BreederCertificationDTO> list(SearchParam searchParam) {
        return null;
    }
}
