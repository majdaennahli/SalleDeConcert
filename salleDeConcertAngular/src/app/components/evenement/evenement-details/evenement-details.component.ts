import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Artiste } from 'src/app/models/artiste';
import { Evenement } from 'src/app/models/evenement';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-evenement-details',
  templateUrl: './evenement-details.component.html',
  styleUrls: ['./evenement-details.component.css'],
})
export class EvenementDetailsComponent {
  evenement!: Evenement;
  artistes: Artiste[] = [];

  constructor(
    private evenementSrv: EvenementService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private authSrv: AuthentificationService
  ) {}

  verifTypeCompte() {
    return this.authSrv.admin;
  }

  ngOnInit(): void {
    this.evenement = new Evenement();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.evenementSrv.getById(params['id']).subscribe((res) => {
          this.evenement = res;
          console.log(this.evenement);

          if (this.evenement.artistes) {
            this.artistes = this.evenement.artistes;
          }

          console.log(this.artistes);
        });
      }
    });
  }
  get login() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).login;
    }
  }
}
