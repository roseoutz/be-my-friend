package be.friend.domain.common.exception;

import java.util.Arrays;
import java.util.Optional;

public enum ErrorCode {
    UNDEFINED_ERROR("error.undefined"),

    /* Friend Error Code */
    FRIEND_NOT_FOUND("error.friend.not.found")
    ;

    private final String errorMsg;

    ErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public static Optional<ErrorCode> find(String errorMsg) {
        return Arrays.stream(ErrorCode.values())
                .filter(errorCode -> errorCode.getErrorMsg().equals(errorMsg))
                .findAny();
    }
}
