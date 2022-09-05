package be.friend.domain.adopt.persistence.service;

import be.friend.domain.adopt.persistence.entity.FriendEntity;
import be.friend.domain.common.persistence.service.PersistenceService;
import be.friend.domain.common.dto.FriendDTO;

public interface FriendPersistenceService extends PersistenceService<FriendDTO, FriendEntity, String> {
}
