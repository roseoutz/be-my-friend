package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import me.friend.domain.common.dto.CertificationTypeDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface CertificationTypePersistenceService extends PersistenceService<CertificationTypeDTO, CertificationTypeEntity, String> {
}
