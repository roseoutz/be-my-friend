package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.ManagerEntity;
import me.friend.domain.common.dto.ManagerDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface ManagerPersistenceService extends PersistenceService<ManagerDTO, ManagerEntity, String> {
}
