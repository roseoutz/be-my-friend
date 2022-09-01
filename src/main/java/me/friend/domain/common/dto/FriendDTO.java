package me.friend.domain.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class FriendDTO extends BaseDto {

    private String oid;
    private String type;
    private String breed;
    private String name;
    private LocalDateTime birthdate;
    @Builder.Default
    private boolean adopted = false;

}
