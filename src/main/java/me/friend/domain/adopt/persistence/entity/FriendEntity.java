package me.friend.domain.adopt.persistence.entity;

import lombok.*;
import me.friend.domain.common.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "bmf_friend"
)
public class FriendEntity extends BaseEntity {

    @Id
    private String oid;

    @Column(nullable = false)
    private String type;

    private String name;

    private LocalDateTime birthdate;

    private boolean adopted = false;

}
