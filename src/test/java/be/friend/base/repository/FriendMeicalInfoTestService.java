package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.FriendMedicalInfoEntity;
import be.friend.domain.adopt.persistence.repository.FriendMedicalInfoRepository;

public class FriendMeicalInfoTestService extends AbstractTestService<FriendMedicalInfoRepository, FriendMedicalInfoEntity, String> {

    public FriendMeicalInfoTestService(FriendMedicalInfoRepository repository) {
        super(repository);
    }
}
