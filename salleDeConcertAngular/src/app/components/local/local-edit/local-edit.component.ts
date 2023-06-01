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
  obsEvenements!: Observable<Evenement[]>;

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.localSrv.getById(params['id']).subscribe((localJson) => {
          this.local = localJson;
        });
      }
    });
    // this.obsEvenements = this.evenementSrv.getEvenements();
  }
  local: Local = new Local();

  constructor(
    private localSrv: LocalService,
    // private evenementSrv: EvenementService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}
  save() {
    if (this.local.id) {
      this.localSrv.update(this.local).subscribe(() => {
        this.router.navigate(['/local']);
      });
    } else {
      this.localSrv.create(this.local).subscribe((localCree) => {
        this.router.navigateByUrl('/local');
      });
    }
  }

  // compareById(frsOptionActive: Evenement, frsSelect: Evenement): boolean {
  //   if (frsSelect && frsOptionActive) {
  //     return frsOptionActive.id === frsSelect.id;
  //   }
  //   return false;
  // }
}
