package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component.QuestionComponent;
//import fr.uga.l3miage.example.exception.rest.QuestionEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestIntIsZeroRestException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.QuestionEntity;
//import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.Question;
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
public class QuestionService {
    /*
    private final QuestionComponent questionComponent;
    private final QuestionMapper questionMapper;

    public Collection<QuestionEntity> getAllQuestions(final Long idMiahoot) {
        if(idMiahoot <= 10 && idMiahoot >= 1) {
            return questionComponent.getAllQuestionsforOneMiahoot(idMiahoot);
        }
        else throw new TestIntIsZeroRestException(" Id non compris entre 1 et 10");
    }

    public void createQuestion(final CreateQuestionRequest request, final Long idMiahoot) {
        if(idMiahoot <= 10 && idMiahoot >= 1) {
            QuestionEntity newQuestionEntity=questionMapper.toEntity(request);
            questionComponent.createQuestionEntity(newQuestionEntity);
        }
        else throw new TestIntIsZeroRestException(" Id non compris entre 1 et 10");
    }
   */
}
