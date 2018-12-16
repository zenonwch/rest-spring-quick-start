package by.zenonwch.spring.exception;

class MyExceptionDto {
    private final String code;
    private final String message;

    MyExceptionDto(final Enum<?> code, final String message) {
        this.code = code.name();
        this.message = message;
    }

    MyExceptionDto(final String message) {
        this.message = message;
        code = "Unexpected";
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
