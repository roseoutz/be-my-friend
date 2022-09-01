package me.friend.adopt.friend;

import me.friend.common.util.UUIDUtil;
import me.friend.domain.adopt.persistence.entity.FriendEntity;
import me.friend.domain.common.dto.FriendDTO;

import java.time.LocalDateTime;

public abstract class AbstractFriendTest {

    protected FriendDTO getFriend() {
        return FriendDTO.builder()
                .oid(UUIDUtil.UUID())
                .type("dog")
                .name("jack")
                .birthdate(LocalDateTime.now())
                .adopted(false)
                .build();
    }

    protected FriendDTO getFriend(String name) {
        return FriendDTO.builder()
                .oid(UUIDUtil.UUID())
                .type("dog")
                .name(name)
                .birthdate(LocalDateTime.now())
                .adopted(false)
                .build();
    }

    protected FriendDTO getFriend(String name, String type) {
        return FriendDTO.builder()
                .oid(UUIDUtil.UUID())
                .type(type)
                .name(name)
                .birthdate(LocalDateTime.now())
                .adopted(false)
                .build();
    }

    protected FriendEntity toEntity(FriendDTO dto) {
        FriendEntity entity = new FriendEntity();
        entity.setOid(dto.getOid());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setBirthdate(dto.getBirthdate());
        entity.setAdopted(dto.isAdopted());

        return entity;
    }
}
