package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

@Getter
public class ReponseEntityNotFoundRestException extends RuntimeException {
    /*
    private final String description;

    public ReponseEntityNotFoundRestException(String message, String description) {
        super(message);
        this.description = description;
    }

    public ReponseEntityNotFoundRestException(String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }

    public HttpStatus getHttpStatus() { return HttpStatus.NOT_FOUND; }

    public ErrorCode getErrorCode() { return ErrorCode.REPONSE_IS_NOT_FOUND; }
    
     */
}
