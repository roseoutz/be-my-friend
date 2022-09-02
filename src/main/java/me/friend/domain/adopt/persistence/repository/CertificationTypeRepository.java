package me.friend.domain.adopt.persistence.repository;

import me.friend.domain.adopt.persistence.entity.CertificationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationTypeRepository extends JpaRepository<CertificationTypeEntity, String> {
}
