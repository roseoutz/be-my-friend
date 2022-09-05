package be.friend.domain.adopt.persistence.repository;

import be.friend.domain.adopt.persistence.entity.CertificationAgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationAgencyRepository extends JpaRepository<CertificationAgencyEntity, String> {
}
