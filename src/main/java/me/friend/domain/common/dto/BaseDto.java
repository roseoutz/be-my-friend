package me.friend.domain.common.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public abstract class BaseDto {

    private LocalDateTime insertTime;
    private LocalDateTime updateTime;

}
