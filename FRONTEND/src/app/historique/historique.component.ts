import { Component } from '@angular/core';
import {Qcm} from "../model/qcm";
import {filter, map, Observable, shareReplay, switchMap} from "rxjs";
import {MiahootsService} from "../miahoots.service";
import {DataService, MiahootUser} from "../data.service";
import {FirestoreService} from "../firestore.service";
import {ImportExportJSONService} from "../import-export-json.service";
import {HistoriqueService} from "./historique.service";

interface STATE {
  user : MiahootUser
  QCMs : Qcm[]
}

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.scss']
})
export class HistoriqueComponent {
  public stateObs: Observable<STATE>;
  isOpen = false;

  constructor(private H : HistoriqueService, private FS: FirestoreService, private data: DataService, private IO : ImportExportJSONService) {

    this.stateObs = H.stateObs.pipe(
        shareReplay(1)
    )

  }


}
