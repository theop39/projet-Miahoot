package fr.uga.l3miage.example.error;


/**
 * Représente les codes d'erreur possibles pour une errorResponse
 * Va permettre d'être le discriminant lors de la deserialization des erreurs
 */
public enum ErrorCode {
    TEST_INT_IS_ZERO_ERROR,
    IS_NOT_TEST_ERROR,
    TEST_IS_NOT_FOUND,
    DESCRIPTION_ALREADY_USE_ERROR,
    TEST_ENTITY_NOT_DELETED_ERROR,
    //REPONSE_IS_NOT_FOUND,
    //IS_NOT_A_QUESTION_OF_THIS_MIAHOOT,
    MIAHOOT_ENTITY_NOT_DELETED_ERROR,
    MIAHOOT_ENTITY_BAD_REQUEST


}
