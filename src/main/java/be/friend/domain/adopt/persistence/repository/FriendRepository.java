package be.friend.domain.adopt.persistence.repository;

import be.friend.domain.adopt.persistence.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, String> {
}
