package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.rest.ReponseEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.ReponseEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ReponseMapper;
import fr.uga.l3miage.example.models.ReponseEntity;
import fr.uga.l3miage.example.repository.ReponseRepository;
import fr.uga.l3miage.example.response.Reponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
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
public class ReponseComponent {

    /*

    private final ReponseRepository reponseRepository;
    private final QuestionRepository questionRepository;

    public Collection<ReponseEntity> getAllQuestionAnswers(Long idQuestion) {
        return questionRepository.getOne(idQuestion).getReponses();
    }


     // Attention: Potentiellement il faudra mettre une limite au nombre de réponse possible voir d'autres choses
     // à prendre en compte. Pour le moment on rend l'entité persistante sans plus de vérification
    public void createReponse(ReponseEntity newReponseEntity) {
        reponseRepository.save(newReponseEntity);
    }

    public ReponseEntity getReponse(Long id) throws ReponseEntityNotFoundException {
        try {
            return reponseRepository.getOne(id);
        } catch (Exception ex) {
            throw new ReponseEntityNotFoundRestException(String.format("Cette réponse n'existe pas"), null, ex);
        }
    }

    public void deleteReponse(Long id) {
        reponseRepository.deleteById(id);
    }
    */


}
