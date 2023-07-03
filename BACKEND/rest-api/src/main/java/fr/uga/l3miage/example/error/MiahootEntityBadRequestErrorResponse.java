package fr.uga.l3miage.example.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

public class MiahootEntityBadRequestErrorResponse extends ErrorResponse {
    protected static final String TYPE_NAME = "RESPONSE_IS_NOT_FOUND";

    /**
     * Cette variable est utilisée que pour la doc dans le swagger<br>
     */
    @Schema(name = "errorCode", description = "Ce code d'erreur est aussi le discriminant pour le polymorphisme",
            allowableValues = TYPE_NAME, implementation = String.class,
            accessMode = Schema.AccessMode.READ_WRITE)
    @JsonProperty(access = WRITE_ONLY)
    private final String errorCodeSwaggerDocumentation = "Field used only to generate documentation, don't use it";

    @Builder
    @Jacksonized
    public MiahootEntityBadRequestErrorResponse(String uri, HttpStatus httpStatus, ErrorCode errorCode, String errorMessage) {
        super(uri, httpStatus, errorCode, errorMessage);
    }
}
