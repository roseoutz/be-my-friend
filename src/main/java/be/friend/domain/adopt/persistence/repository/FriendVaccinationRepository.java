package be.friend.domain.adopt.persistence.repository;

import be.friend.domain.adopt.persistence.entity.FriendVaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendVaccinationRepository extends JpaRepository<FriendVaccinationEntity, String> {
}
