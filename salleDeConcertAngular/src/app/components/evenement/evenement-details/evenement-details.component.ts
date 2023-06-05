import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-evenement-details',
  templateUrl: './evenement-details.component.html',
  styleUrls: ['./evenement-details.component.css'],
})
export class EvenementDetailsComponent {
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

  goBack() {
    window.history.back();
  }
}
