package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.models.QuestionEntity;
import fr.uga.l3miage.example.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
 * Respect de l'architecture hexagonale, on ne traite ici que les données
 */

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    /*
    // private final MiahootRepository miahootRepository;
    private final QuestionRepository questionRepository;

  // public Collection<Question> getAllQuestionsforOneMiahoot(Long idMiahoot) {
        //return miahootRepository.GetQuestions();
   // }

    public void createQuestionEntity(QuestionEntity nouveauQuestionEntity) {
        questionRepository.save(nouveauQuestionEntity);
    }
    public Collection<QuestionEntity> getAllQuestionsforOneMiahoot(Long idMiahoot) {
        return questionRepository.findAll();
    }
    */

}


