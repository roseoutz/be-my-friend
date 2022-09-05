package be.friend.domain.adopt.persistence.repository;

import be.friend.domain.adopt.persistence.entity.VaccineInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineInfoRepository extends JpaRepository<VaccineInfoEntity, String> {
}
