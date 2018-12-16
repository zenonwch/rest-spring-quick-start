package by.zenonwch.spring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(final Exception ex, final WebRequest request) {
        final String message = ex.getMessage();

        return new ResponseEntity<>(new MyExceptionDto(message), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MyRuntimeException.class)
    public ResponseEntity<MyExceptionDto> handleMyException(final MyRuntimeException ex, final WebRequest request) {
        final Enum<?> exceptionCode = ex.getCode();
        final String exceptionMessage = ex.getMessage();
        final HttpStatus responseStatus = ex.getStatus();

        return new ResponseEntity<>(new MyExceptionDto(exceptionCode, exceptionMessage), new HttpHeaders(), responseStatus);
    }
}
