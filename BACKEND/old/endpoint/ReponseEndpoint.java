package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.error.ReponseNotFoundErrorResponse;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.Reponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Pour l'instant on centralise les transmissions autour du miahoot donc tous les endpoints précédemment crées ici ne sont pas utiliser
 * A décommenter/faire évoluer en cas de besoin
 */

@Tag(name = "Requêtes sur les réponses")
@CrossOrigin
@RestController
@RequestMapping("api/v0/")
public interface ReponseEndpoint {


    /**
     * Endpoint définit pour la récupération de toutes les réponses affiliées à une question
     */

    /*
    @Operation(description = "Récupérer toutes les réponses d'une question")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de toutes les entités Reponse associé à l'id de la question demandé",
            content = @Content(schema = @Schema(implementation = Reponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si aucun miahoot ne correspond à l'idMiahoot ou si " +
            "aucune question correspondant à l'idQuestion n'est trouvé dans ce miahoot",
            content = @Content(schema = @Schema(implementation = ReponseNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoots/{idMiahoot}/questions/{idQuestion}")
    Collection<Reponse> getAllEntityReponseOfAQuestion(@NotNull @PathVariable("idMiahoot") Long idMiahoot,
                                                       @NotNull @PathVariable("idQuestion") Long idQuestion);
    */

    /**
     * Endpoint définit pour la création d'une entité de type Reponse associé à l'une des questions d'un miahoot d'un
     * enseignant
     */

    /*
    @Operation(description = "Création d'une entité Reponse")
    @ApiResponse(responseCode = "201", description = "La Reponse a été créée avec succès")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si aucun miahoot ne correspond à l'idMiahoot ou si " +
            "aucune question correspondant à l'idQuestion n'est trouvé dans ce miahoot",
            content = @Content(schema = @Schema(implementation = ReponseNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @Error400Custom
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("miahoots/{idMiahoot}/questions/{idQuestion}")
    void createEntityReponse(@Valid @RequestBody CreateReponseRequest request,
                             @NotNull @PathVariable("idMiahoot") Long idMiahoot,
                             @NotNull @PathVariable("idQuestion") Long idQuestion);
    */

    /**
     * Endpoint définit pour la suppression d'une entité de type Reponse associé à l'une des questions d'un miahoot d'un enseignant
     * ATTENTION: Remplacer le schéma implémentation par une classe d'exeption spéciale pour le delete de reponse
     */

    /*
    @Operation(description = "Suppression d'une entité Reponse")
    @ApiResponse(responseCode = "200", description = "La réponse a été supprimée avec succès")
    @ApiResponse(responseCode = "418", description = "L'entité n'a pas pu être supprimé. Renvoie l'erreur théière",
        content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("miahoots/{idMiahoot}/questions/{idQuestion}/reponses/{idReponse}")
    void deleteReponseEntity(@NotNull @PathVariable("idMiahoot") Long idMiahoot,
                             @NotNull @PathVariable("idQuestion") Long idQuestion,
                             @NotNull @PathVariable("idReponse") Long idReponse);
   */
}
