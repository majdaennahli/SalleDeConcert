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
  artistes!: Artiste[];

  staffs!: Staff[];
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
    this.obsLocaux = this.localSrv.getLocaux();
    this.artisteSrv.getArtistes().subscribe((res) => {
      this.artistes = res;
    });

    this.staffSrv.getStaffs().subscribe((res) => (this.staffs = res));
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.evenementSrv.getById(params['id']).subscribe((res) => {
          this.evenement = res;
          for (let artiste of this.artistes) {
            for (let prestataire of this.evenement.artistes!) {
              if (artiste.id == prestataire.id) {
                artiste.checked = true;
              }
            }
          }
          for (let staff of this.staffs) {
            for (let staff2 of this.evenement.staffs!) {
              if (staff.id == staff2.id) {
                staff.checked = true;
              }
            }
          }
        });
      }
    });
  }

  save() {
    this.evenement.artistes = this.artistes.filter(
      (artiste) => artiste.checked
    );

    this.evenement.staffs = this.staffs.filter((staff) => staff.checked);

    console.log(this.evenement);
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
  compareByTypeEvenement(
    typeOptionActive: string,
    typeSelect: string
  ): boolean {
    if (typeSelect && typeOptionActive) {
      return typeOptionActive === typeSelect;
    }
    return false;
  }
}
