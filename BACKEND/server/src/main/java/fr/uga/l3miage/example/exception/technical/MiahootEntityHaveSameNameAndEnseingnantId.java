package fr.uga.l3miage.example.exception.technical;

public class MiahootEntityHaveSameNameAndEnseingnantId extends Exception {
    private final String description;

    public MiahootEntityHaveSameNameAndEnseingnantId(String message, String description) {
        super(message);
        this.description = description;
    }

    public MiahootEntityHaveSameNameAndEnseingnantId (String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }
}
