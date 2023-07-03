package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.component.ReponseComponent;
import fr.uga.l3miage.example.exception.rest.ReponseEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.IsNotAQuestionOfThisMiahootRestException;
import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.ReponseEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.models.QuestionEntity;
import fr.uga.l3miage.example.models.ReponseEntity;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.response.Reponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * !!! ATTENTION !!!
 * Comme on a décidé de manipuler l'entité miahoot en elle même, on a plus besoin pour le moment des endpoints sur les entités Question et Reponse
 * Donc on a désactivé cette classe
 * NOTE: certaines des classes mises en commentaire n'ont pas étées fini car les entités Miahoot, Question et Reponse ont été réalisé par 3 personnes différentes
 * puis merge ensemble. Et la décision de n'utiliser que les endpoints de Miahoot c'est faite après.
 *
 */

@Service
@RequiredArgsConstructor
public class ReponseService {

    /*
    private final ReponseComponent reponseComponent;
    private final ReponseMapper reponseMapper;
    private final MiahootComponent miahootComponent;
    private final QuestionComponent questionComponent;

    public Collection<Reponse> getAllReponses(final Long idMiahoot, final Long idQuestion) {
        try {
            MiahootEntity miahootEntity = miahootComponent.getMiahoot(idMiahoot);
            QuestionEntity questionEntity = questionComponent;
            if (miahootEntity.getId() == question.getMiahoot().getId()) {
                return reponseMapper.toDto(reponseComponent.getAllQuestionAnswers(idQuestion));
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question n'existe pas"), null, ex);
        }
    }

    public void createReponse(final CreateReponseRequest request, final Long idMiahoot, final Long idQuestion) {
        try {
            MiahootEntity miahootEntity = miahootComponent.getMiahoot(idMiahoot);
            QuestionEntity questionEntity = questionComponent.getQuestion(idQuestion);
            if (miahoot.getId(id) == question.getMiahoot().getId()) {
                ReponseEntity newReponseEntity = reponseMapper.toEntity(request);
                reponseComponent.createReponse(newReponseEntity);
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question n'existe pas"), null, ex);
        }
    }

    public void deleteReponse(final Long idMiahoot, final Long idQuestion, final Long idReponse) {
        try {
            MiahootEntity miahoot = miahootComponent.getMiahoot(idMiahoot);
            QuestionEntity question = questionComponent.getQuestion(idQuestion);
            ReponseEntity reponse = reponseComponent.getReponse(idReponse);
            if (miahoot.getId(id) == question.getMiahoot().getId() && question.getId() == reponse.getQuestion().getId()) {
                reponseComponent.deleteReponse(idReponse);
            } else throw new IsNotAQuestionOfThisMiahootRestException("Cette question ne fait pas partie de ce Miahoot ou cette réponse n'est pas liée à cette question");
        } catch (MiahootEntityNotFoundException | QuestionEntityNotFoundException | ReponseEntityNotFoundException ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Le miahoot ou la question ou la réponse n'existe pas"), null, ex);
        }

    }
    */

}


