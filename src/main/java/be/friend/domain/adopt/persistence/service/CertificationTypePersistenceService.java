package be.friend.domain.adopt.persistence.service;

import be.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import be.friend.domain.common.dto.CertificationTypeDTO;
import be.friend.domain.common.persistence.service.PersistenceService;

public interface CertificationTypePersistenceService extends PersistenceService<CertificationTypeDTO, CertificationTypeEntity, String> {
}
