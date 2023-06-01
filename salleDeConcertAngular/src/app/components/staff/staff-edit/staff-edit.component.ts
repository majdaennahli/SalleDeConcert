import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Staff } from 'src/app/models/staff';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { StaffService } from 'src/app/services/staff.service';

@Component({
  selector: 'app-staff-edit',
  templateUrl: './staff-edit.component.html',
  styleUrls: ['./staff-edit.component.css'],
})
export class StaffEditComponent {
  staff!: Staff;

  constructor(
    private staffSrv: StaffService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.staff = new Staff();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.staffSrv.getById(params['id']).subscribe((res) => {
          this.staff = res;
        });
      }
    });
  }

  save() {
    if (this.staff.id) {
      this.staffSrv.update(this.staff).subscribe((res) => {
        this.router.navigateByUrl('/staff');
      });
    } else {
      this.staffSrv.create(this.staff).subscribe((res) => {
        this.router.navigateByUrl('/staff');
      });
    }
  }
}
