import { AuthentificationService } from 'src/app/services/authentification.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';
import { Time } from '@angular/common';

@Component({
  selector: 'app-evenement-list',
  templateUrl: './evenement-list.component.html',
  styleUrls: ['./evenement-list.component.css'],
})
export class EvenementListComponent implements OnInit {
  evenements!: Evenement[];
  filtre = '';

  constructor(private evenementSrv: EvenementService) {}

  evenementFiltre() {
    const filtreLowerCase = this.filtre.toLowerCase();

    return this.evenements.filter(
      (e) => e.nom?.toLowerCase().indexOf(filtreLowerCase) != -1
    );
  }

  ngOnInit(): void {
    this.listEvenements();
  }

  listEvenements() {
    this.evenementSrv.getEvenement().subscribe((resultat) => {
      this.evenements = resultat;
    });
  }

  deleteEvenement(id: number) {
    this.evenementSrv.delete(id).subscribe(() => {
      this.listEvenements();
    });
  }
}
