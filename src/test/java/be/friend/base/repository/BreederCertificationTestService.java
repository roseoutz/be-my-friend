package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import be.friend.domain.adopt.persistence.repository.BreederCertificationRepository;


public class BreederCertificationTestService extends AbstractTestService<BreederCertificationRepository, BreederCertificationEntity, String> {

    public BreederCertificationTestService(BreederCertificationRepository repository) {
        super(repository);
    }

}
