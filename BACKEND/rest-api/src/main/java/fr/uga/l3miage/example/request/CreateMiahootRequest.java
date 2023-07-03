package fr.uga.l3miage.example.request;

import fr.uga.l3miage.example.response.Question;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Builder
@Schema(description = "correspond au DTO d'un miahoot transmis par requete client")
public class CreateMiahootRequest {

    @Schema(description = "Correspond au nom donné au Miahoot", example = "QCM seance 2")
    private String nom;

    @Schema(description = "Correspond à l'id du proprietaire du Miahoot", example = "45")
    private String idEnseignant; //sera transmis par le client pour la creation via le JSON

    @Schema(description = "Correspond aux questions de ce miahoot")
    List<Question> questions;

}

