import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, filter, map, Observable, of, switchAll, switchMap, combineLatest} from "rxjs";
import {HistoriqueProjectedMiahoot} from "../firestore.service";
import {HistoRepQcm, PresentationService} from "../presentation.service";
import {collection, Firestore, getDocs} from "@angular/fire/firestore";
import {ActivatedRoute} from "@angular/router";
import {Qcm} from "../model/qcm";
import {MiahootsService} from "../miahoots.service";
import {DataService, MiahootUser} from "../data.service";
import {user} from "@angular/fire/auth";
import {ResultatsService} from "./resultats.service";

interface STATE {
    user: MiahootUser | undefined,
    qcm: Qcm,
    historiquesReponses: HistoRepQcm[]
}

@Component({
    selector: 'app-affichage-resultats',
    templateUrl: './affichage-resultats.component.html',
    styleUrls: ['./affichage-resultats.component.scss']
})
export class AffichageResultatsComponent{
    stateBS : BehaviorSubject<STATE | undefined> = new BehaviorSubject<STATE | undefined>(undefined)
    stateObs = this.stateBS.asObservable();
    idMiahootProjete : string = this.route.snapshot.paramMap.get('id') as string;
    QCM !: Qcm;
    constructor(private RS : ResultatsService, private MS : MiahootsService, private route : ActivatedRoute, private DS : DataService) {
        this.RS.getAllReponsesOfProjectedMiahoot(this.idMiahootProjete)
        this.getQcmByIdMetier(this.idMiahootProjete).then(value => this.QCM = value)
        combineLatest([this.RS.stateObs, this.DS.miahootUserObs]).pipe(
            filter(([state, user]) => state.historiquesReponses.length > 0 && user !== undefined),
            map(([state, user]) => {
                return {
                    user: user,
                    historiquesReponses: state.historiquesReponses
                }
            }),
            switchMap(async (value) => {
                const state : STATE = {
                    user : value.user,
                    qcm : await this.getQcmByIdMetier(this.idMiahootProjete),
                    historiquesReponses : value.historiquesReponses
                }
                return state;
            }
        )).subscribe(this.stateBS)
        
    }

    getQcmByIdMetier(idMetier: string) {
        return this.MS.getQcmByIdMetier(idMetier)
    }

    delete(projectedmiahootID : string){
        this.RS.deleteProjectedMiahoot(projectedmiahootID)
    }
}
