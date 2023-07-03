package fr.uga.l3miage.example.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "DTO Question ")
public class Question {

    @Schema(description = "correspond à une question", example = "Quelle est la couleur du cheval blanc d'Henri IV")
    String label;

    @Schema(description = "correspond à la liste des réponses possible à cette question")
    List<Reponse> reponses;

}
