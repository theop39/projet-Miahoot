package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.response.Miahoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MiahootRepository extends JpaRepository<MiahootEntity, Long> {

    Optional<MiahootEntity> findById(final Long id);

    Optional<MiahootEntity> findByIdMetier(final String idMetier);

    Collection<MiahootEntity> findAllByIdEnseignant(final String idEnseignant);

    Optional<Collection<MiahootEntity>> findAllMiahootByIdEnseignant(String idEnseignant);

    //int deleteByIdEnseignant(final String idEnseignant);

    int deleteByIdMetier(final String idMetier);

}