package by.zenonwch.spring.exception;

import org.springframework.http.HttpStatus;

class MyRuntimeException extends RuntimeException {
    private final Enum<?> code;
    private final HttpStatus status;

    MyRuntimeException(final String message, final Enum<?> code, final HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    Enum<?> getCode() {
        return code;
    }

    HttpStatus getStatus() {
        return status;
    }
}
