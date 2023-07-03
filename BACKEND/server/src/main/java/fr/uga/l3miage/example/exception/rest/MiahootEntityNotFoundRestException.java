package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class MiahootEntityNotFoundRestException extends RuntimeException {
    private final String description;

    public MiahootEntityNotFoundRestException (String message, String description) {
        super(message);
        this.description = description;
    }

    public MiahootEntityNotFoundRestException (String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ErrorCode getErrorCode(){return ErrorCode.TEST_ENTITY_NOT_DELETED_ERROR;}
}