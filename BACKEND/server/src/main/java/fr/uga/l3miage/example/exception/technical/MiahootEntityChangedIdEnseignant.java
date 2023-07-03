package fr.uga.l3miage.example.exception.technical;

public class MiahootEntityChangedIdEnseignant extends Exception {
    private final String description;

    public MiahootEntityChangedIdEnseignant(String message, String description) {
        super(message);
        this.description = description;
    }

    public MiahootEntityChangedIdEnseignant (String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }
}
