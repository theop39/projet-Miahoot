package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.ReponseEntity;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.request.CreateReponseRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Reponse;
import fr.uga.l3miage.example.response.Test;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Au besoin ajouter un mapper de Collection de request dans le cas ou on implémente quelque chose qui permet de recevoir depuis
 * le client plusieurs request de réponse en une fois
  */

@Mapper
public interface ReponseMapper {

    Reponse toDto(ReponseEntity reponseEntity);

    Collection<Reponse> toDto(Iterable<ReponseEntity> reponseEntities);

    ReponseEntity toEntity(CreateReponseRequest request);
}
