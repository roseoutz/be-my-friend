package be.friend.domain.adopt.persistence.service;

import be.friend.domain.adopt.persistence.entity.VaccineInfoEntity;
import be.friend.domain.common.dto.VaccineInfoDTO;
import be.friend.domain.common.persistence.service.PersistenceService;

public interface VaccineInfoPersistenceService extends PersistenceService<VaccineInfoDTO, VaccineInfoEntity, String> {
}
