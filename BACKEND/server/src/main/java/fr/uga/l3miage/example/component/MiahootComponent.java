package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.response.Miahoot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;

    //recuperer un miahoot via son id

    //get un Miahoot via son id
    public MiahootEntity getMiahoot(final String idMetier) throws MiahootEntityNotFoundException {
        return miahootRepository.findByIdMetier(idMetier)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité de Miahoot n'a été trouvée pour l'id [%s]", idMetier), idMetier));
    }

    public Collection<MiahootEntity> getAllMiahoot() {
        return miahootRepository.findAll();

    }

    // Renvoie tous les Miahoot présent dans la base de donnée associé à l'idEnseignant
    public Collection<MiahootEntity> getAllEnseignantMiahoot(String idEnseignant) throws MiahootEntityNotFoundException {
        return miahootRepository.findAllMiahootByIdEnseignant(idEnseignant)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité de Miahoot n'a été trouvée pour l'id [%s]", idEnseignant), idEnseignant));
    }


    public Miahoot createMiahoot(final MiahootEntity newMiahoot) throws MiahootEntityHaveSameNameAndEnseingnantId {

        boolean nameAlreadyUsed = false;

        try {
            Collection<MiahootEntity> allMiahootForEnseignant = null;
            allMiahootForEnseignant =  getAllEnseignantMiahoot(newMiahoot.getIdEnseignant());


            Iterator<MiahootEntity> it = allMiahootForEnseignant.iterator();

            while(it.hasNext() && !nameAlreadyUsed) {

                MiahootEntity m = it.next();

                if (newMiahoot.getNom().equals(m.getNom())) {
                    nameAlreadyUsed = true;
                }
            }

        }catch (Exception e) {}

        if (nameAlreadyUsed) {
            throw new MiahootEntityHaveSameNameAndEnseingnantId("Plusieurs entités ont le même nom pour l'id enseignant " + newMiahoot.getIdEnseignant(), newMiahoot.getIdEnseignant());
        }

        miahootRepository.save(newMiahoot);

        Miahoot createdMiahoot = this.miahootMapper.toDto(newMiahoot);

        createdMiahoot.setIdMetier(newMiahoot.getIdMetier());

        return createdMiahoot;

        //return newMiahoot.getIdMetier();
    }

    public Miahoot updateMiahoot(Miahoot miahoot, String idMetier) throws MiahootEntityNotFoundException, MiahootEntityChangedIdEnseignant, MiahootEntityHaveSameNameAndEnseingnantId {
        MiahootEntity miahootEntity = miahootRepository.findByIdMetier(idMetier)
                .orElseThrow(() -> new MiahootEntityNotFoundException(String.format("Aucune entité miahoot ayant l'id métier [%s] n'a été trouvé", idMetier), idMetier));


        if (!miahootEntity.getIdEnseignant().equals(miahoot.getIdEnseignant())) {
            throw new MiahootEntityChangedIdEnseignant("Impossible de changer la valeur de l'attribut id enseignant "
                    + miahootEntity.getIdEnseignant() + " (attribut readonly)",  miahootEntity.getIdEnseignant());
        }

        boolean nameAlreadyUsed = false;

        try {
            Collection<MiahootEntity> allMiahootForEnseignant = null;
            allMiahootForEnseignant =  getAllEnseignantMiahoot(miahoot.getIdEnseignant());

            Iterator<MiahootEntity> it = allMiahootForEnseignant.iterator();

            while(it.hasNext() && !nameAlreadyUsed) {

                MiahootEntity m = it.next();

                if (miahoot.getNom().equals(m.getNom()) && !miahoot.getIdMetier().equals(m.getIdMetier())) {
                    nameAlreadyUsed = true;
                }
            }
        }catch (Exception e) {
        }

        if(nameAlreadyUsed) {
            throw new MiahootEntityHaveSameNameAndEnseingnantId("Plusieurs entités ont le même nom pour l'id enseignant " +  miahoot.getIdEnseignant(), miahoot.getIdEnseignant());
        }

        /*
        if (nameAlreadyUsed) {
            throw new MiahootEntityHaveSameNameAndEnseingnantId("Plusieurs entités ont le même nom pour l'id enseignant " + miahoot.getIdEnseignant(), miahoot.getIdEnseignant());
        } */

        miahootMapper.mergeMiahootEntity(miahootEntity, miahoot);
        miahootRepository.save(miahootEntity);

        return this.miahootMapper.toDto(miahootEntity);
    }

    //delete un miahoot via son id
    public void deleteMiahoot(final String idMetier) throws MiahootEntityNotFoundException, MultipleEntityHaveSameDescriptionException {
        int deleted = miahootRepository.deleteByIdMetier(idMetier);
        if (deleted > 1) {
            throw new MultipleEntityHaveSameDescriptionException("Plusieurs entités ont le même id métier alors que c'est impossible ".concat(idMetier));
        } else if (deleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Aucune entité miahoot ayant l'id métier [%s] n'a été trouvé", idMetier), idMetier);
        };
    }

    /*
    //delete tous les mihaoots qui appartiennent à l'auteur dont l'id est passé par paramètre
    public void deleteMiahoots(final String idEnseignant) throws MiahootEntityNotFoundException  {
        int nbMiahootDeleted = this.miahootRepository.deleteByIdEnseignant(idEnseignant);

        //si nbMiahootDeleted > 0 , on part du principe que pas de probleme métier car plusieurs miahoot peuvent avoir le meme nom
        if (nbMiahootDeleted == 0) {
            throw new MiahootEntityNotFoundException(String.format("Erreur de suppression, aucun Miahoot n'a d'auteur dont l'id est  [%d] en base", auteurId), Long.toString(auteurId));
        }
    }
    */
}
