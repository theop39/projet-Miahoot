package fr.uga.l3miage.example.config.handler;


import fr.uga.l3miage.example.error.ErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.rest.MiahootEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import fr.uga.l3miage.example.response.Miahoot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ConditionalOnWebApplication
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class MiahootNotFoundExceptionHandler {

    @ExceptionHandler(MiahootEntityNotFoundRestException.class)
    public ResponseEntity<ErrorResponse> handle(HttpServletRequest httpServletRequest, Exception exception) {
        MiahootEntityNotFoundRestException ex = (MiahootEntityNotFoundRestException) exception;
        final TestNotFoundErrorResponse response = TestNotFoundErrorResponse.builder()
                .uri(httpServletRequest.getRequestURI())
                .httpStatus(ex.getHttpStatus())
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .description(ex.getDescription())
                .build();
        log.warn(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }
}
