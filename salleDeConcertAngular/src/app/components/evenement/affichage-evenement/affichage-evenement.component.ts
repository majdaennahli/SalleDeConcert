import { Component } from '@angular/core';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-affichage-evenement',
  templateUrl: './affichage-evenement.component.html',
  styleUrls: ['./affichage-evenement.component.css'],
})
export class AffichageEvenementComponent {
  evenements!: Evenement[];

  constructor(private evenementSrv: EvenementService) {}

  ngOnInit(): void {
    this.listEvenements();
  }

  listEvenements() {
    this.evenementSrv.getEvenement().subscribe((resultat) => {
      this.evenements = resultat;
    });
  }
}
