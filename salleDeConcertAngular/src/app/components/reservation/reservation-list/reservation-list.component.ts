import { Client } from './../../../models/client';
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Artiste } from 'src/app/models/artiste';
import { Reservation } from 'src/app/models/reservation';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ClientService } from 'src/app/services/client.service';
import { EvenementService } from 'src/app/services/evenement.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent {
  reservations!: Reservation[];
  client!: Client;
  idReservation!: number;
  date = new Date();

  constructor(
    private reservationSrv: ReservationService,
    private clientSrv: ClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private authSrv: AuthentificationService,
    private datePipe: DatePipe
  ) {
    this.ClientInfo();
  }

  ClientInfo() {
    const clientInfo = sessionStorage.getItem('compte');
    if (clientInfo) {
      this.client = JSON.parse(clientInfo);
    }
  }

  verifTypeCompte() {
    return this.authSrv.admin;
  }

  ngOnInit(): void {
    this.listReservations();
  }

  calculateNombrePlaces() {
    for (let reservation of this.client?.reservations!) {
      reservation.nombrePlaces =
        reservation.prix! / reservation.evenement?.prix!;
    }
  }
  listReservations() {
    console.log(this.date);
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clientSrv
          .getByIdWithReservations(params['id'])
          .subscribe((res) => {
            this.client = res;
            this.calculateNombrePlaces();
            console.log(this.client.naissance!.getTime! < this.date.getTime!);
            console.log(this.client.naissance);
          });
      }
    });
  }

  deleteReservation(idReservation: number) {
    this.reservationSrv.delete(idReservation).subscribe(() => {
      this.listReservations();
    });
  }

  checkDate(reservation: Reservation): boolean {
    if (reservation.evenement?.dateDebut! <= this.date) {
      return false;
    }
    return true;
  }
}
