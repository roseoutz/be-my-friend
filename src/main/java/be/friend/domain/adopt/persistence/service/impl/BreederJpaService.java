package be.friend.domain.adopt.persistence.service.impl;

import be.friend.common.util.StringCheckUtil;
import be.friend.common.util.UUIDUtil;
import be.friend.domain.adopt.persistence.entity.BreederEntity;
import be.friend.domain.adopt.persistence.repository.BreederRepository;
import be.friend.domain.adopt.persistence.service.BreederPersistenceService;
import be.friend.domain.common.dto.BreederDTO;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.exception.ErrorCode;
import be.friend.domain.common.exception.ParameterInvalidException;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public BreederDTO add(BreederDTO dto) {
        BreederEntity entity = convertToEntity(dto);

        if (entity == null) {
            throw new ParameterInvalidException(ErrorCode.PARAMETER_IS_NULL);
        }

        if (StringCheckUtil.isNull(entity.getOid())) {
            entity.setOid(UUIDUtil.UUID());
        }

        BreederEntity saved = getRepository().save(entity);

        return convertToDTO(saved);
    }

    @Transactional
    @Override
    public BreederDTO update(BreederDTO dto) {
        return getRepository().findById(dto.getOid())
                .map(entity -> update(dto, entity))
                .map(this::convertToDTO)
                .get();
    }

    private BreederEntity update(BreederDTO dto, BreederEntity entity) {
        if (isNotNullAndNotEqual(entity.getAddress(), dto.getAddress())) {
            entity.setAddress(dto.getAddress());
        }

        if (isNotNullAndNotEqual(entity.getHomeContact(), dto.getHomeContact())) {
            entity.setHomeContact(dto.getHomeContact());
        }

        if (isNotNullAndNotEqual(entity.getMobileContact(), dto.getMobileContact())) {
            entity.setMobileContact(dto.getMobileContact());
        }

        if (isNotNullAndNotEqual(entity.getSnsAddress(), dto.getSnsAddress())) {
            entity.setSnsAddress(dto.getSnsAddress());
        }

        if (isNotNullAndNotEqual(entity.getImageUrl(), dto.getImageUrl())) {
            entity.setImageUrl(dto.getImageUrl());
        }

        if (isNotNullAndNotEqual(entity.getName(), dto.getName())) {
            entity.setName(dto.getName());
        }

        return getRepository().save(entity);
    }

    @Transactional
    @Override
    public void delete(String oid) {
        getRepository().deleteById(oid);
    }

    @Transactional
    @Override
    public Optional<BreederDTO> get(String oid) {
        return getRepository().findById(oid)
                .map(this::convertToDTO);
    }

    @Override
    public List<BreederDTO> list(SearchParam searchParam) {
        return null;
    }
}
