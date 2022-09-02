package me.friend.domain.adopt.persistence.repository;

import me.friend.domain.adopt.persistence.entity.FriendMedicalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendMedicalInfoRepository extends JpaRepository<FriendMedicalInfoEntity, String> {
}
