import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'src/app/models/evenement';
import { Local } from 'src/app/models/local';
import { EvenementService } from 'src/app/services/evenement.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  evenement!: Evenement;
  local!: Local;
  obsLocals!: Observable<Local[]>;

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

  compareById(localOptionActive: Local, localSelect: Local): boolean {
    if (localSelect && localOptionActive) {
      return localOptionActive.id === localSelect.id;
    }
    return false;
  }

  reserver() {
    // A FAIRE
  }

  ajoutPanier() {
    // Futur évolution
  }
}
