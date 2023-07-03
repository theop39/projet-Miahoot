package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class MiahootEntityBadRequestRestException extends RuntimeException {
    public MiahootEntityBadRequestRestException(String message) {
        super(message);
    }

    public MiahootEntityBadRequestRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    public ErrorCode getErrorCode(){return ErrorCode.MIAHOOT_ENTITY_BAD_REQUEST;}
}
