import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  evenement!: Evenement;

  constructor(
    private evenementSrv: EvenementService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.evenement = new Evenement();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.evenementSrv.getById(params['id']).subscribe((res) => {
          this.evenement = res;
        });
      }
    });
  }

  save() {
    // A FAIRE
  }
}
