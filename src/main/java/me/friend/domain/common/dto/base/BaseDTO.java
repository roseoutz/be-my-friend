package me.friend.domain.common.dto.base;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseDTO extends TimeBaseDTO {

    private String insertUser;
    private String updateUser;
}
