package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.QuestionEntity;
//import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.Question;
import org.mapstruct.Mapper;

import java.util.Collection;


@Mapper
public interface QuestionMapper {

        Question toDto(QuestionEntity questionEntity);

        Collection<Question> toDto(Iterable<QuestionEntity> questionEntities);

        QuestionEntity toEntity(CreateQuestionRequest request);

        Collection<QuestionEntity> toEntity(Iterable<Question> questions);
}
