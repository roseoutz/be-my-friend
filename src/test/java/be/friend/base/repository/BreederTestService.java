package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.BreederEntity;
import be.friend.domain.adopt.persistence.repository.BreederRepository;

public class BreederTestService extends AbstractTestService<BreederRepository, BreederEntity, String> {

    public BreederTestService(BreederRepository repository) {
        super(repository);
    }

}
