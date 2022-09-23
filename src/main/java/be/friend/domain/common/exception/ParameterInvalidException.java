package be.friend.domain.common.exception;

import org.springframework.http.HttpStatus;

public class ParameterInvalidException extends BaseException {

    public ParameterInvalidException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }

    public ParameterInvalidException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ParameterInvalidException(String errorMsg) {
        super(errorMsg);
    }

    public ParameterInvalidException(Throwable throwable) {
        super(throwable);
    }
}
