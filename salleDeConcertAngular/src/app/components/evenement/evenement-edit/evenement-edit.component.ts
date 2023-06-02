import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Artiste } from 'src/app/models/artiste';
import { Evenement } from 'src/app/models/evenement';
import { Local } from 'src/app/models/local';
import { Reservation } from 'src/app/models/reservation';
import { Staff } from 'src/app/models/staff';
import { ArtisteService } from 'src/app/services/artiste.service';
import { EvenementService } from 'src/app/services/evenement.service';
import { LocalService } from 'src/app/services/local.service';
import { StaffService } from 'src/app/services/staff.service';

@Component({
  selector: 'app-evenement-edit',
  templateUrl: './evenement-edit.component.html',
  styleUrls: ['./evenement-edit.component.css'],
})
export class EvenementEditComponent implements OnInit {
  evenement!: Evenement;
  obsLocaux!: Observable<Local[]>;
  obsArtistes!: Observable<Artiste[]>;
  obsStaffs!: Observable<Staff[]>;
  // obsReservations!: Observable<Reservation[]>;

  constructor(
    private evenementSrv: EvenementService,
    private localSrv: LocalService,
    //private reservationSrv: ReservationService,
    private artisteSrv: ArtisteService,
    private staffSrv: StaffService,
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
    this.obsLocaux = this.localSrv.getLocaux();
    this.obsArtistes = this.artisteSrv.getArtistes();
    //this.obsReservations = this.reservationSrv.getReservations();
    this.obsStaffs = this.staffSrv.getStaffs();
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
  compareByIdLocal(locOptionActive: Local, locSelect: Local): boolean {
    if (locSelect && locOptionActive) {
      return locOptionActive.id === locSelect.id;
    }
    return false;
  }
  // compareByIdReservation(frsOptionActive: Reservation, frsSelect: Reservation): boolean {
  //   if (frsSelect && frsOptionActive) {
  //     return frsOptionActive.id === frsSelect.id;
  //   }
  //   return false;
  // }
  compareByIdStaff(stfOptionActive: Staff, stfSelect: Staff): boolean {
    if (stfSelect && stfOptionActive) {
      return stfOptionActive.id === stfSelect.id;
    }
    return false;
  }
  compareByIdArtiste(artOptionActive: Artiste, artSelect: Artiste): boolean {
    if (artSelect && artOptionActive) {
      return artOptionActive.id === artSelect.id;
    }
    return false;
  }
}
