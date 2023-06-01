import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Evenement } from 'src/app/models/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-evenement-edit',
  templateUrl: './evenement-edit.component.html',
  styleUrls: ['./evenement-edit.component.css'],
})
export class EvenementEditComponent {
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
    if (this.evenement.id) {
      this.evenementSrv.update(this.evenement).subscribe((res) => {
        this.router.navigateByUrl('/evenement');
      });
    } else {
      this.evenementSrv.create(this.evenement).subscribe((res) => {
        this.router.navigateByUrl('/evenement');
      });
    }
  }
}
