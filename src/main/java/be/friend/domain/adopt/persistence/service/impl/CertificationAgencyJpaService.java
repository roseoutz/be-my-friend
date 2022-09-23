package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import be.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;
import be.friend.domain.adopt.persistence.service.CertificationAgencyPersistenceService;
import be.friend.domain.common.dto.CertificationAgencyDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("certificationAgencyJpaService")
public class CertificationAgencyJpaService
    extends AbstractPersistenceService<CertificationAgencyRepository, CertificationAgencyEntity, CertificationAgencyDTO, String>
    implements CertificationAgencyPersistenceService {
    public CertificationAgencyJpaService(CertificationAgencyRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<CertificationAgencyDTO> getDtoClass() {
        return CertificationAgencyDTO.class;
    }

    @Override
    protected Class<CertificationAgencyEntity> getEntityClass() {
        return CertificationAgencyEntity.class;
    }

    @Override
    public CertificationAgencyDTO add(CertificationAgencyDTO dto) {
        return null;
    }

    @Override
    public CertificationAgencyDTO update(CertificationAgencyDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<CertificationAgencyDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<CertificationAgencyDTO> list(SearchParam searchParam) {
        return null;
    }
}
