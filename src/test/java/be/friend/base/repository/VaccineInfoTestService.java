package be.friend.base.repository;

import be.friend.domain.adopt.persistence.entity.VaccineInfoEntity;
import be.friend.domain.adopt.persistence.repository.VaccineInfoRepository;

public class VaccineInfoTestService extends AbstractTestService<VaccineInfoRepository, VaccineInfoEntity, String> {

    public VaccineInfoTestService(VaccineInfoRepository repository) {
        super(repository);
    }
}
