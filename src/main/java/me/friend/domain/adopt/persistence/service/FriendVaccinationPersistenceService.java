package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.FriendVaccinationEntity;
import me.friend.domain.common.dto.FriendVaccinationDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface FriendVaccinationPersistenceService extends PersistenceService<FriendVaccinationDTO, FriendVaccinationEntity, String> {
}
