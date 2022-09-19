package be.friend.domain.adopt.persistence.service.impl;

import be.friend.domain.adopt.persistence.entity.VaccineInfoEntity;
import be.friend.domain.adopt.persistence.repository.VaccineInfoRepository;
import be.friend.domain.adopt.persistence.service.VaccineInfoPersistenceService;
import be.friend.domain.common.dto.SearchParam;
import be.friend.domain.common.dto.VaccineInfoDTO;
import be.friend.domain.common.persistence.service.AbstractPersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineInfoJpaService
    extends AbstractPersistenceService<VaccineInfoRepository, VaccineInfoEntity, VaccineInfoDTO, String>
    implements VaccineInfoPersistenceService {

    public VaccineInfoJpaService(VaccineInfoRepository repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        super(repository, jpaQueryFactory, objectMapper);
    }

    @Override
    protected Class<VaccineInfoDTO> getDtoClass() {
        return VaccineInfoDTO.class;
    }

    @Override
    protected Class<VaccineInfoEntity> getEntityClass() {
        return VaccineInfoEntity.class;
    }

    @Override
    public VaccineInfoDTO add(VaccineInfoDTO dto) {
        return null;
    }

    @Override
    public VaccineInfoDTO update(VaccineInfoDTO dto) {
        return null;
    }

    @Override
    public void delete(String oid) {

    }

    @Override
    public Optional<VaccineInfoDTO> get(String oid) {
        return Optional.empty();
    }

    @Override
    public List<VaccineInfoDTO> list(SearchParam searchParam) {
        return null;
    }
}
