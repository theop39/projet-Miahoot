package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;

@Mapper
public interface MiahootMapper {
    Miahoot toDto(MiahootEntity reponseEntity);

    Collection<Miahoot> toDto(Iterable<MiahootEntity> miahootEntities);

    MiahootEntity toEntity(CreateMiahootRequest miahootRequest);

    void mergeMiahootEntity(@MappingTarget @NonNull MiahootEntity baseEntity, Miahoot miahoot);
}