package by.zenonwch.spring.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends MyRuntimeException {
    public UserNotFoundException(final String message) {
        super(message, MyErrorCodes.UserNotFound, HttpStatus.NOT_FOUND);
    }
}