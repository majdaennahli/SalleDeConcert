import { AuthentificationService } from 'src/app/services/authentification.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-evenement-list',
  templateUrl: './evenement-list.component.html',
  styleUrls: ['./evenement-list.component.css'],
})
export class EvenementListComponent implements OnInit {
  obsEvenements!: Observable<Evenement[]>;

  constructor(
    private evenementSrv: EvenementService,
    private authSrv: AuthentificationService
  ) {}

  ngOnInit(): void {
    this.obsEvenements = this.evenementSrv.getAll();
  }
  delete(id: number) {
    this.evenementSrv.delete(id).subscribe(() => {
      this.obsEvenements = this.evenementSrv.getAll();
    });
  }
}
