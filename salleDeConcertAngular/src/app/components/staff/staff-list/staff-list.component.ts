import { Component, OnInit } from '@angular/core';
import { Staff } from 'src/app/models/staff';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { StaffService } from 'src/app/services/staff.service';

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css'],
})
export class StaffListComponent implements OnInit {
  staffs!: Staff[];
  filtre = '';

  constructor(private staffSrv: StaffService) {}

  staffFiltre() {
    const filtreLowerCase = this.filtre.toLowerCase();

    return this.staffs.filter(
      (f) => f.nom?.toLowerCase().indexOf(filtreLowerCase) != -1
    );
  }

  ngOnInit(): void {
    this.listStaffs();
  }

  listStaffs() {
    this.staffSrv.getStaffs().subscribe((resultat) => {
      this.staffs = resultat;
    });
  }

  deleteStaff(id: number) {
    this.staffSrv.delete(id).subscribe(() => {
      this.listStaffs();
    });
  }
}
