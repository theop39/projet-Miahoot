import {Component, Injectable} from "@angular/core";
import {DataService, MiahootUser} from "../data.service";
import {Qcm} from "../model/qcm";
import {HistoRepQcm} from "../presentation.service";
import {BehaviorSubject, map, Observable, of} from "rxjs";
import {collection, deleteDoc, doc, Firestore, getDocs, updateDoc} from "@angular/fire/firestore";
import {ActivatedRoute} from "@angular/router";
import {MiahootsService} from "../miahoots.service";


interface STATE {
    historiquesReponses: HistoRepQcm[]
}
@Injectable({
    providedIn: 'root'
})
export class ResultatsService {
    mu : MiahootUser | undefined;
    stateBS: BehaviorSubject<STATE> = new BehaviorSubject<STATE>({
        historiquesReponses: []
    });
    stateObs = this.stateBS.asObservable();

    constructor(private firestore: Firestore, private route: ActivatedRoute, private MS: MiahootsService, private dataService: DataService) {
    }

    async getAllReponsesOfProjectedMiahoot(idMiahootProjete: string) {
        const querySnapshot = await getDocs(collection(this.firestore, `historiqueProjectedMiahoots/${idMiahootProjete}/allReponses`))
        let tabRepQcm: HistoRepQcm[] = [];
        querySnapshot.forEach((doc) => {
            let data = doc.data() as HistoRepQcm
            tabRepQcm.push(data)
        })

        of(tabRepQcm).pipe(
            map(value => {
                const a =  {
                    historiquesReponses: value
                }
                this.stateBS.next(a)
            })).subscribe()
    }

    public async deleteProjectedMiahoot(miahootIDProjected : string) {

        /**
         * Ici on supprime les collections historiqueProjectedMiahoot et ProjectedMiahoot
         */
        const allPMQCMDoc = await getDocs(collection(this.firestore, `projectedMiahoots/${miahootIDProjected}/QCMs`));
        allPMQCMDoc.forEach(async docum => {
            let docRefProjectedMiahootQCMs = doc(this.firestore, `projectedMiahoots/${miahootIDProjected}/QCMs/${docum.id}`)
            let deleteQCMs = await deleteDoc(docRefProjectedMiahootQCMs)
        })

        const allHistoQCMDoc = await getDocs(collection(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/QCMs`));
        allHistoQCMDoc.forEach(async docum => {

            let allProjectedRep = await getDocs(collection(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/QCMs/${docum.id}/ProjectedReponse`));
            allProjectedRep.forEach(async docum2 => {
                let docRefProjectedRep = doc(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/QCMs/${docum.id}/ProjectedReponse/${docum2.id}`)
                let deleteProjectedRep = await deleteDoc(docRefProjectedRep)
            })

            let docRefHistoQcms = doc(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/QCMs/${docum.id}`)
            let deleteHistoQcm = await deleteDoc(docRefHistoQcms)
        })

        const allHistoAllRepDoc = await getDocs(collection(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/allReponses`));
        allHistoAllRepDoc.forEach(async docum => {
            let docRefHistoAllRep = doc(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}/allReponses/${docum.id}`)
            let deleteAllRep = await deleteDoc(docRefHistoAllRep)
        })

        const docRefProjectedMiahoot = doc(this.firestore, `projectedMiahoots/${miahootIDProjected}`)
        const docRefHistoriqueProjectedMiahoot = doc(this.firestore, `historiqueProjectedMiahoots/${miahootIDProjected}`)

        try {
            const delProjectedMiahoot = await deleteDoc(docRefProjectedMiahoot)
            const delHistoriqueProjectedMiahoot = await deleteDoc(docRefHistoriqueProjectedMiahoot)
        } catch (err) {
            console.log(`Error when trying to delete current projected Miahoot or Historique: ${err}`)
        }

        /**
         * Ici on enlève l'id métier du miahoot qui a été projeté des utilisateurs qui y ont participés
         */
        const allUsers = await getDocs(collection(this.firestore, `user`))
        allUsers.forEach( async user => {
            let data = user.data() as MiahootUser
            if (data.projectedMiahoot === miahootIDProjected) {
                let docUser = doc(this.firestore, `user/${data.id}`)
                let update = await updateDoc(docUser, {projectedMiahoot: ""})
            }
        })
    }
}