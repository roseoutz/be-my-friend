package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import be.friend.domain.adopt.persistence.repository.CertificationTypeRepository;

public class CertificationTypeTestService extends AbstractTestService<CertificationTypeRepository, CertificationTypeEntity, String> {

    public CertificationTypeTestService(CertificationTypeRepository repository) {
        super(repository);
    }
}
