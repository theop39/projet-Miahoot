package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.error.QuestionNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.Question;
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

@Tag(name = "Requêtes pour les questions")
@CrossOrigin
@RestController
@RequestMapping("api/v0/")
public interface QuestionEndpoint {
        /**
         * Endpoint définit pour la récupération de toutes les questions*/

        /*
        @Operation(description = "Récupérer toutes les questions")
        @ApiResponse(responseCode = "200", description = "Renvoie le DTO de toutes les entités Questions associé à l'id d'un miahoot demandé",
                content = @Content(schema = @Schema(implementation = Question.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
        @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si aucun miahoot ne correspond à l'idMiahoot ou si ",
                content = @Content(schema = @Schema(implementation = QuestionNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
        @ResponseStatus(HttpStatus.OK)
        @GetMapping("miahoots/{idMiahoot}")
        Collection<Question> getAllQuestion(@NotNull @PathVariable("idMiahoot") Long idMiahoot);
        */

        /**
         * Endpoint définit pour la création d'une entité de type Reponse associé à l'une des question d'un miahoot d'un
         * enseignant*/

        /*
        @Operation(description = "Création d'une entité question")
        @ApiResponse(responseCode = "201", description = "L'entité Question a bien été créée")
        @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si aucun miahoot ne correspond à l'idMiahoot ou si ",
                content = @Content(schema = @Schema(implementation = QuestionNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
        @Error400Custom
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("miahoots/{idMiahoot}")
        void createEntityQuestion(@Valid @RequestBody CreateQuestionRequest request,
                                 @NotNull @PathVariable("idMiahoot") Long idMiahoot);
        */

}
