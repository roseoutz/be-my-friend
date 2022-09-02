package me.friend.domain.adopt.persistence.repository;

import me.friend.domain.adopt.persistence.entity.BreederCertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreederCertificationRepository extends JpaRepository<BreederCertificationEntity, String> {
}
