package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.VaccineInfoEntity;
import me.friend.domain.common.dto.VaccineInfoDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface VaccineInfoPersistenceService extends PersistenceService<VaccineInfoDTO, VaccineInfoEntity, String> {
}
