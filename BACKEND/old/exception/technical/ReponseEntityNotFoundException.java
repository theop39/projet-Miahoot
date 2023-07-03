package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

/**
 * Exception technique
 */
@Getter
public class ReponseEntityNotFoundException extends Exception {
    /*
    private final String description;

    public ReponseEntityNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }

    public ReponseEntityNotFoundException(String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }

     */
}
