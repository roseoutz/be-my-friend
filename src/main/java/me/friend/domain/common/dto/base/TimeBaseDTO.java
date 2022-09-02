package me.friend.domain.common.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public abstract class TimeBaseDTO {

    @Builder.Default
    private LocalDateTime insertTime = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updateTime = LocalDateTime.now();;

}
