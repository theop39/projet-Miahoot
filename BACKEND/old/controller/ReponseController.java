package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.annotations.Error400Custom;
import fr.uga.l3miage.example.endpoint.ReponseEndpoint;
import fr.uga.l3miage.example.error.ReponseNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.Reponse;
import fr.uga.l3miage.example.service.ReponseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

/**
 * Cette classe correspond à l'implémentation de l'interface {@link ReponseEndpoint}<br>
 */

@RestController
@RequiredArgsConstructor
public class ReponseController implements ReponseEndpoint {
/*
    private final ReponseService reponseService;

    @Override
    public Collection<Reponse> getAllEntityReponseOfAQuestion(final Long idMiahoot, final Long idQuestion) {
        return reponseService.getAllReponses(idMiahoot, idQuestion);
    }

    @Override
    public void createEntityReponse(final CreateReponseRequest request, final Long idMiahoot, final Long idQuestion) {
        reponseService.createReponse(request, idMiahoot, idQuestion);
    }

    @Override
    public void deleteReponseEntity(Long idMiahoot, Long idQuestion, Long idReponse) {
        reponseService.deleteReponse(idMiahoot, idQuestion, idReponse);
    };
*/
}
