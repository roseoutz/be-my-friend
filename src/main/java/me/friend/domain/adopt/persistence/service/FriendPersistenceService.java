package me.friend.domain.adopt.persistence.service;

import me.friend.domain.adopt.persistence.entity.FriendEntity;
import me.friend.domain.common.dto.FriendDTO;
import me.friend.domain.common.persistence.service.PersistenceService;

public interface FriendPersistenceService extends PersistenceService<FriendDTO, FriendEntity, String> {
}
