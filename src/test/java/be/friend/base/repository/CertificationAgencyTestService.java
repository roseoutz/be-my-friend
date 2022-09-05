package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import be.friend.domain.adopt.persistence.repository.CertificationAgencyRepository;


public class CertificationAgencyTestService extends AbstractTestService<CertificationAgencyRepository, CertificationAgencyEntity, String> {

    public CertificationAgencyTestService(CertificationAgencyRepository repository) {
        super(repository);
    }

}
