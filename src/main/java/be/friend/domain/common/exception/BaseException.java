package be.friend.domain.common.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BaseException(String errorMsg) {
        super(errorMsg);
        this.errorCode = ErrorCode.find(errorMsg)
                .orElse(ErrorCode.UNDEFINED_ERROR);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BaseException(Throwable throwable) {
        super(throwable);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = ErrorCode.UNDEFINED_ERROR;
    }
}
