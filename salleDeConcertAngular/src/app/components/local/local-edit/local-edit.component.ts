import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Evenement } from 'src/app/models/evenement';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Local } from 'src/app/models/local';
import { EvenementService } from 'src/app/services/evenement.service';
import { LocalService } from 'src/app/services/local.service';
@Component({
  selector: 'app-local-edit',
  templateUrl: './local-edit.component.html',
  styleUrls: ['./local-edit.component.css'],
})
export class LocalEditComponent implements OnInit {
  local!: Local;

  constructor(
    private localSrv: LocalService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.local = new Local();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.localSrv.getById(params['id']).subscribe((res) => {
          this.local = res;
        });
      }
    });
  }

  save() {
    if (this.local.id) {
      this.localSrv.update(this.local).subscribe((res) => {
        this.router.navigateByUrl('/local');
      });
    } else {
      this.localSrv.create(this.local).subscribe((res) => {
        this.router.navigateByUrl('/local');
      });
    }
  }
  // this.obsEvenements = this.evenementSrv.getEvenements();
  // compareById(frsOptionActive: Evenement, frsSelect: Evenement): boolean {
  //   if (frsSelect && frsOptionActive) {
  //     return frsOptionActive.id === frsSelect.id;
  //   }
  //   return false;
  // }
}
