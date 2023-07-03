import {BehaviorSubject, filter, map, Observable, switchMap} from "rxjs";
import {DataService, MiahootUser} from "../data.service";
import {Qcm} from "../model/qcm";
import {Injectable} from "@angular/core";
import {RequestService} from "../request.service";
import {environment} from "../../environments/environment";

interface STATE {
    user : MiahootUser
    QCMs : Qcm[]
}

@Injectable({
    providedIn: 'root'
})
export class HistoriqueService {
    private stateBS: BehaviorSubject<STATE> = new BehaviorSubject<STATE>( this.initValue() );
    readonly stateObs = this.stateBS.asObservable()
    url: string = `${environment.springServer}${RequestService.PATH}`

    constructor(private data: DataService, private RS : RequestService) {

        data.miahootUserObs.pipe(
            filter( U => U !== undefined ),
            map( U => U as MiahootUser ),
            switchMap( async U => {
                const state: STATE = {
                    user: U,
                    QCMs: await RS.getHistorique<Qcm[]>( `${this.url}?id=${U.id}`)
                }
                return state;
            })
        ).subscribe(this.stateBS)
    }

    private initValue(): STATE {
        const defMiahoot: MiahootUser = { id: '1', name: 'default', photoURL: 'default', projectedMiahoot: "" };
        return {user: defMiahoot, QCMs: []}
    }
}
