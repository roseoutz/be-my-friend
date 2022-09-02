package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.BreederEntity;
import me.friend.domain.common.dto.BreederDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface BreederPersistenceService extends PersistenceService<BreederDTO, BreederEntity, String> {
}
