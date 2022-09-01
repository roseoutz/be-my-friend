package me.friend.adopt.friend;

import me.friend.domain.common.dto.FriendDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FriendTest {

    @Test
    void test_adopt_friend() {
        // given
        FriendDTO friendDTO = FriendDTO.builder()
                .oid("test")
                .type("dog")
                .name("jack")
                .birthdate(LocalDateTime.now())
                .adopted(false)
                .build();

        assertFalse(friendDTO.isAdopted(), "already adopted friend");

    }
}
