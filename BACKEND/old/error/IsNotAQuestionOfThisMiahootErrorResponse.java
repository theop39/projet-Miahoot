package fr.uga.l3miage.example.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

/*
@JsonTypeName(IsNotAQuestionOfThisMiahootErrorResponse.TYPE_NAME)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = "errorCodeSwaggerDocumentation")
@Schema(subTypes = ErrorResponse.class)
public class IsNotAQuestionOfThisMiahootErrorResponse extends ErrorResponse {

    protected static final String TYPE_NAME = "IS_NOT_A_QUESTION_OF_THIS_MIAHOOT";

    // Cette variable est utilisée que pour la doc dans le swagger<br>

    @Schema(name = "errorCode", description = "Ce code d'erreur est aussi le discriminant pour le polymorphisme",
            allowableValues = TYPE_NAME, implementation = String.class,
            accessMode = Schema.AccessMode.READ_WRITE)
    @JsonProperty(access = WRITE_ONLY)
    private final String errorCodeSwaggerDocumentation = "Field used only to generate documentation, don't use it";

    @Builder
    @Jacksonized
    public IsNotAQuestionOfThisMiahootErrorResponse(String uri, HttpStatus httpStatus, ErrorCode errorCode, String errorMessage, String description) {
        super(uri, httpStatus, errorCode, errorMessage);
    }
}

 */
