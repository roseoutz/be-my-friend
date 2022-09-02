package me.friend.domain.adopt.persistence.repository;

import me.friend.domain.adopt.persistence.entity.BreederEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreederRepository extends JpaRepository<BreederEntity, String> {
}
