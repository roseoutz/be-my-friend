package me.friend.domain.adopt.persistence.repository;

import me.friend.domain.adopt.persistence.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, String> {
}
