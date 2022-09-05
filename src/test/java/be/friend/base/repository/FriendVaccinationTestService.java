package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.FriendVaccinationEntity;
import be.friend.domain.adopt.persistence.repository.FriendVaccinationRepository;

public class FriendVaccinationTestService extends AbstractTestService<FriendVaccinationRepository, FriendVaccinationEntity, String> {

    public FriendVaccinationTestService(FriendVaccinationRepository repository) {
        super(repository);
    }
}
