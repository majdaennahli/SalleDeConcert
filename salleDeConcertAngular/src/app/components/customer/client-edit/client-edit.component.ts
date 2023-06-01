import { Component, NgModule } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from 'src/app/models/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css'],
})
export class ClientEditComponent {
  client!: Client;

  constructor(
    private clientSrv: ClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.client = new Client();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clientSrv.getById(params['id']).subscribe((res) => {
          this.client = res;
        });
      }
    });
  }
  get nom() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).nom;
    }
  }
  save() {
    if (this.client.id) {
      this.clientSrv.update(this.client).subscribe((res) => {
        this.router.navigateByUrl('/customer/home');
      });
    } else {
      this.clientSrv.create(this.client).subscribe((res) => {
        this.router.navigateByUrl('/customer/home');
      });
    }
  }
}
