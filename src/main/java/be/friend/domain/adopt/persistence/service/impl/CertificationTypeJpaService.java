package be.friend.domain.adopt.persistence.service.impl;

import be.friend.common.util.StringCheckUtil;
import be.friend.common.util.UUIDUtil;
import be.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import be.friend.domain.adopt.persistence.repository.CertificationTypeRepository;
import be.friend.domain.adopt.persistence.service.CertificationTypePersistenceService;
import be.friend.domain.common.dto.CertificationTypeDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.exception.ErrorCode;
import be.friend.domain.common.exception.ParameterInvalidException;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("certificationTypeJpaService")
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

    @Transactional
    @Override
    public CertificationTypeDTO add(CertificationTypeDTO dto) {

        CertificationTypeEntity entity = convertToEntity(dto);

        if (entity == null) {
            throw new ParameterInvalidException(ErrorCode.PARAMETER_IS_NULL);
        }

        if (StringCheckUtil.isNull(entity.getOid())) {
            entity.setOid(UUIDUtil.UUID());
        }

        CertificationTypeEntity saved = getRepository().save(entity);

        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public CertificationTypeDTO update(CertificationTypeDTO dto) {
        return null;
    }

    @Transactional
    @Override
    public void delete(String oid) {
        getRepository().deleteById(oid);
    }

    @Override
    public Optional<CertificationTypeDTO> get(String oid) {
        return getRepository().findById(oid)
                .map(this::convertToDTO);
    }

    @Override
    public List<CertificationTypeDTO> list(SearchParam searchParam) {
        return null;
    }
}
