package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.exception.rest.*;
import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.idgenerator.IdMetierMiahootGenerator;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.MiahootEntity;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.response.Miahoot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MiahootService {

    private final MiahootMapper miahootMapper;
    private final MiahootComponent miahootComponent;

    public Miahoot createMiahoot(final CreateMiahootRequest request) {


        try {
            MiahootEntity newMiahootEntity = this.miahootMapper.toEntity(request);

            newMiahootEntity.setIdMetier(IdMetierMiahootGenerator.generateIdMetier());

            return this.miahootComponent.createMiahoot(newMiahootEntity);
        }
        catch (MiahootEntityHaveSameNameAndEnseingnantId cause) {
            throw new MiahootEntityBadRequestRestException("Erreur création d'un Miahoot : impossible de creer le Miahoot correspondant\n"
                                                         + "car son enseignant possede deja un miahoot qui porte ce nom"
                                                         + "Cause : " + cause.getMessage(), cause);
        }
        catch (Exception cause) {
            throw new MiahootEntityBadRequestRestException("Erreur création d'un Miahoot : impossible de creer le Miahoot correspondant\n"
                                                           + "Cause : " + cause.getMessage(), cause);
        }
    }

    //get un miahoot via son id au format DTO
    public Miahoot getMiahoot(final String idMetier) {

        try {
            return miahootMapper.toDto(miahootComponent.getMiahoot(idMetier));
        } catch (MiahootEntityNotFoundException e) {
            throw new MiahootEntityNotFoundRestException(String.format("Impossible de charger l'entité. Raison : [%s]",e.getMessage()), idMetier, e);
        }
    }


    // TODO Faut t'il vraiment ajouter une exception si il ne trouve rien?

    // Renvoie tous les Miahoot présent dans la base de données
    public Collection<Miahoot> getAllMiahoot() {
        Collection<MiahootEntity> miahootEntities = miahootComponent.getAllMiahoot();
        MiahootEntity m = miahootEntities.iterator().next();
        return miahootMapper.toDto(miahootEntities);

    }

    // Renvoie tous les Miahoot présent dans la base de donnée associé à l'idEnseignant
    public Collection<Miahoot> getAllEnseignantMiahoot(String idEnseignant) {
        try {
            return miahootMapper.toDto(miahootComponent.getAllEnseignantMiahoot(idEnseignant));
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundRestException(String.format("Impossible de charger l'entité"), null);
        }
    }

    @Transactional
    public void deleteMiahoot(final String idMetier) {
        try {
            miahootComponent.deleteMiahoot(idMetier);
        } catch (MiahootEntityNotFoundException | MultipleEntityHaveSameDescriptionException e) {
            throw new MiahootEntityNotDeletedRestException(e.getMessage());
        }
    }

    public Miahoot updateMiahoot(Miahoot miahoot, String idMetier) {

        if (miahoot.getIdMetier().equals(idMetier)) {
            try {
                return miahootComponent.updateMiahoot(miahoot, idMetier);
            }catch (MiahootEntityHaveSameNameAndEnseingnantId cause) {
                throw new MiahootEntityBadRequestRestException("Erreur création d'un Miahoot : impossible de creer le Miahoot correspondant\n"
                        + "car son enseignant possede deja un miahoot qui porte ce nom"
                        + "Cause : " + cause.getMessage(), cause);
            }

            catch (MiahootEntityNotFoundException ex) {
                throw new MiahootEntityNotFoundRestException(String.format("Aucune entité miahoot ayant l'id métier [%s] n'a été trouvé", idMetier), idMetier);
            } catch (MiahootEntityChangedIdEnseignant cause) {
                throw new MiahootEntityBadRequestRestException("L'id enseignant a été changé " +  cause.getMessage(), cause);
            }/*
            catch (MiahootEntityHaveSameNameAndEnseingnantId cause) {
                throw new MiahootEntityBadRequestRestException("Erreur création d'un Miahoot : impossible de creer le Miahoot correspondant\n"
                        + "car son enseignant possede deja un miahoot qui porte ce nom"
                        + "Cause : " + cause.getMessage(), cause);
            } */
            catch (Exception cause) {
                throw new MiahootEntityBadRequestRestException("Erreur de l'update du Miahoot : impossible  modifier le Miahoot correspondant\n"
                        + "Cause : " + cause.getMessage(), cause);
            }
        } else {
            throw new MiahootEntityBadRequestRestException("L'id métier de l'url ne correspond pas à l'id métier du miahoot");
        }

    }
}