package be.friend.domain.adopt.persistence.service;

import be.friend.domain.adopt.persistence.entity.ManagerEntity;
import be.friend.domain.common.dto.ManagerDTO;
import be.friend.domain.common.persistence.service.PersistenceService;

public interface ManagerPersistenceService extends PersistenceService<ManagerDTO, ManagerEntity, String> {
}
