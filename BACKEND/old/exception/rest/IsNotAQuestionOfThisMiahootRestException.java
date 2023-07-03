package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

public class IsNotAQuestionOfThisMiahootRestException extends RuntimeException{

    /*
    public IsNotAQuestionOfThisMiahootRestException(String message) {
        super(message);
    }

    public IsNotAQuestionOfThisMiahootRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    public ErrorCode getErrorCode(){return ErrorCode.IS_NOT_A_QUESTION_OF_THIS_MIAHOOT; }

     */

}