import { Component } from '@angular/core';
import {Observable} from "rxjs";
import {Qcm} from "../model/qcm";
import {DataService, MiahootUser} from "../data.service";
import {PresentateurService} from "./presentateur.service";
import {FirestoreService} from "../firestore.service";
import {Router} from "@angular/router";

interface STATE {
    user: MiahootUser;
    qcms: Qcm[];

}
@Component({
  selector: 'app-presentateur',
  templateUrl: './presentateur.component.html',
  styleUrls: ['./presentateur.component.scss']
})
export class PresentateurComponent {
    readonly obsState: Observable<STATE>;
    constructor(presentateurService : PresentateurService, private FS: FirestoreService, private data: DataService, private router: Router) {
        this.obsState = presentateurService.obsState;
    }

    async presenterUnMiahoot(miahoot: Qcm) {
        this.data.updateMiahootUser({projectedMiahoot: miahoot.idMetier})
        await this.FS.addProjectedMiahoot(miahoot)
        this.goToPage('miahoots/gameroom/' + miahoot.idMetier)
    }

    public goToPage(pageName: string) {
        this.router.navigate([`${pageName}`]);
    }

}
