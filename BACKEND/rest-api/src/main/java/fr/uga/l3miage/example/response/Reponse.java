package fr.uga.l3miage.example.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "correspond au DTO de l'entité Reponse. Autrement dit, ce que le serveur va renvoyé au client")
public class Reponse {

    @Schema(description = "correspond à l'une des réponses possibles de la question dont cette réponse est lié",
    example = "42")
    String label;

    @Schema(description = "indique si cette réponse est la/l'une des bonnes réponse de la question dont elle est lié",
    example = "true")
    Boolean estValide;

}
