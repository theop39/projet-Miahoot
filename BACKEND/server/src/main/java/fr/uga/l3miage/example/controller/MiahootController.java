package fr.uga.l3miage.example.controller;


import fr.uga.l3miage.example.endpoint.ExampleEndpoint;
import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.request.CreateMiahootRequest;
import fr.uga.l3miage.example.request.CreateTestRequest;
import fr.uga.l3miage.example.response.Miahoot;
import fr.uga.l3miage.example.response.Test;
import fr.uga.l3miage.example.service.MiahootService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class MiahootController implements MiahootEndpoint {

    private final MiahootService miahootService;

    /**
     *
     * @param idEnseignant id de l'enseignant pour lequel on cherche ses miahoots.
     * @return Tous les miahoots associés à idEnseignant ou bien tous les miahoots si cet id est null
     */
    public Collection<Miahoot> getAllEntityMiahoot(String idEnseignant) {
        if (idEnseignant == null) {
            return miahootService.getAllMiahoot();
        } else {
            return miahootService.getAllEnseignantMiahoot(idEnseignant);
        }
    }

    @Override
    public Miahoot getEntityMiahoot(final String idMetier) {
        return miahootService.getMiahoot(idMetier);
    }

    @Override
    public Miahoot createEntityMiahoot(final CreateMiahootRequest request) {
        return this.miahootService.createMiahoot(request);
    }

    @Override
    public void deleteMiahootEntity(final String idMetier) {
        miahootService.deleteMiahoot(idMetier);
    }

    public Miahoot updateMiahootEntity(final Miahoot miahoot, final String idMetier) {
        return miahootService.updateMiahoot(miahoot, idMetier);
    }
}
