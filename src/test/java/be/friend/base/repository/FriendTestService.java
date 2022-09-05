package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.FriendEntity;
import be.friend.domain.adopt.persistence.repository.FriendRepository;

public class FriendTestService extends AbstractTestService<FriendRepository, FriendEntity, String> {

    public FriendTestService(FriendRepository repository) {
        super(repository);
    }
}
