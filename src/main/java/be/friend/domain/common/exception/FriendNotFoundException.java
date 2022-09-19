package be.friend.domain.common.exception;

import org.springframework.http.HttpStatus;

public class FriendNotFoundException extends BaseException {

    public FriendNotFoundException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }

    public FriendNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public FriendNotFoundException(String errorMsg) {
        super(errorMsg);
    }

    public FriendNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
