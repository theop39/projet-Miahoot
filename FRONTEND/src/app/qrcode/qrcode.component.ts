import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-qrcode',
  templateUrl: './qrcode.component.html',
  styleUrls: ['./qrcode.component.scss']
})

export class QrcodeComponent {

  @Input() idRoom!: string;

  constructor () {

  }
/*
  ici il faudra la fonction qui une fois une url fix définit 
  pour la room étendra cette dernière avec l'id de la room en question
  pour y accéder,
  pour le moment seul id apparait dans le qrcode
  */
}
