package fr.uga.l3miage.example.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

@Data
@Builder
@Schema(description = "correspond à la requête permettant de créer une entité de type reponse")
public class CreateReponseRequest {
    /*
    @Schema(description = "correspond à l'une des réponses possibles de la question dont cette réponse est lié",
            example = "42")
    private String label;

    @Schema(description = "indique si cette réponse est la/l'une des bonnes réponse de la question dont elle est lié",
            example = "true")
    private boolean estValide;

    */

}
