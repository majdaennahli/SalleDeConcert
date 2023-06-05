import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/models/client';
import { Evenement } from 'src/app/models/evenement';
import { Local } from 'src/app/models/local';
import { Reservation } from 'src/app/models/reservation';
import { EvenementService } from 'src/app/services/evenement.service';
import { LocalService } from 'src/app/services/local.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  form!: FormGroup;
  dateNow: Date = new Date();
  expiration: string =
    this.dateNow.getFullYear() +
    '-' +
    (this.dateNow.getMonth() + 1).toString().padStart(2, '0');

  evenement!: Evenement;
  reservation: Reservation = new Reservation();
  prixFinal!: number;
  nombrePlaces!: number;
  client!: Client;
  local!: Local;

  constructor(
    private evenementSrv: EvenementService,
    private reservationSrv: ReservationService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private localSrv: LocalService
  ) {}

  ngOnInit(): void {
    this.evenement = new Evenement();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.evenementSrv.getById(params['id']).subscribe((res) => {
          this.evenement = res;
          console.log(this.evenement);
        });
      }
    });

    this.form = new FormGroup({
      porteur: new FormControl('', Validators.required),
      numcarte: new FormControl('', Validators.required),
      expiration: new FormControl('', Validators.required),
      code: new FormControl('', Validators.required),
    });
  }

  save() {
    this.reservation.prix = this.prixFinal;
    this.reservation.dateReserv = new Date();
    //this.reservation.client = sessionStorage.getItem('compte') as Client;
    const clientInfo = sessionStorage.getItem('compte');
    if (clientInfo) {
      this.client = JSON.parse(clientInfo);
    }
    this.reservation.client = this.client;
    this.reservation.evenement = this.evenement;
    this.localSrv.getById(this.evenement.local?.id!).subscribe((result) => {
      this.local = result;

      console.log(this.evenement.local);
      this.evenement.local!.placesAssises! -= this.nombrePlaces;
      // =this.evenement.local.placesAssises - ;
      console.log(this.evenement.local);
      this.localSrv.update(this.evenement.local!).subscribe((result) => {
        this.reservationSrv.create(this.reservation).subscribe((res) => {
          this.router.navigateByUrl('/client/home');
        });
      });
    });
    //Décrémenter le nb de place du local
  }

  calculatePrixFinal() {
    if (this.evenement.prix !== undefined) {
      this.prixFinal = this.evenement.prix * this.nombrePlaces;
    }
  }
}
