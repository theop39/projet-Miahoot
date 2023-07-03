package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.error.MiahootNotFoundErrorResponse;
import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
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

@Tag(name = "Miahoot tag")
@CrossOrigin
@RestController
@RequestMapping("api/v0/")
public interface MiahootEndpoint {

    /**
     * Attention le paramètre est récupéré en tant que string dans l'url. Il faudra le convertir en Long au besoin
     */

    @Operation(description = "Ce endpoint renvoie tous les miahoot stockés dans la base de données si le paramètre idEnseignant n'est pas donnée. " +
            "S'il est donnée celà renvoit tous les miahoot de l'enseignant associé à cet id. " +
            "Note: Dans le cas applicatif on donnera toujours l'id. Sans l'id est utile pour les tests")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de tous les miahoots d'un enseignant sauvegardés dans la base de données si l'id" +
            " de l'enseignant est donné en paramètre ou TOUS les miahoot sauvegardés dans la base de donnée",
            content = @Content(schema = @Schema(implementation = Miahoot.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si aucune entité miahoot n'est trouvée",
            content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoots")
    Collection<Miahoot> getAllEntityMiahoot(@RequestParam(name = "id", required = false) String idEnseignant);


    @Operation(description = "Récupérer le DTO de l'entité Miahoot qui a pour id celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité test demandée",
            content = @Content(schema = @Schema(implementation = Miahoot.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("miahoots/{idMetier}")
    Miahoot getEntityMiahoot(@PathVariable String idMetier);


    @Operation(description = "Création d'une entité Miahoot")
    @ApiResponse(responseCode = "201", description = "L'entité Miahoot a bien été créée.")
    @Error400Custom
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("miahoots")
    Miahoot createEntityMiahoot(@Valid @RequestBody CreateMiahootRequest request);


    @Operation(description = "Mise à jour d'une entité Miahoot")
    @ApiResponse(responseCode = "200", description = "L'entité à bien été mise à jour")
    @ApiResponse(responseCode = "404", description = "L'entité n'a pas pu être trouvé")
    @Error400Custom
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("miahoots/{idMetier}")
    Miahoot updateMiahootEntity(@Valid @RequestBody final Miahoot miahoot,
                             @NotNull @PathVariable final String idMetier);


    @Operation(description = "Suppression d'une entité Miahoot en bd")
    @ApiResponse(responseCode = "204", description = "la ressource a bien été supprimé")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("miahoots/{idMetier}")
    void deleteMiahootEntity(@NotNull @PathVariable final String idMetier);
}