package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import be.friend.domain.adopt.persistence.repository.CertificationTypeRepository;
import be.friend.domain.adopt.persistence.service.CertificationTypePersistenceService;
import be.friend.domain.common.dto.CertificationTypeDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationTypeJpaService
    extends AbstractPersistenceService<CertificationTypeRepository, CertificationTypeEntity, CertificationTypeDTO, String>
    implements CertificationTypePersistenceService {
    public CertificationTypeJpaService(CertificationTypeRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<CertificationTypeDTO> getDtoClass() {
        return CertificationTypeDTO.class;
    }

    @Override
    protected Class<CertificationTypeEntity> getEntityClass() {
        return CertificationTypeEntity.class;
    }

    @Override
    public CertificationTypeDTO add(CertificationTypeDTO dto) {
        return null;
    }

    @Override
    public CertificationTypeDTO update(CertificationTypeDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<CertificationTypeDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<CertificationTypeDTO> list(SearchParam searchParam) {
        return null;
    }
}
