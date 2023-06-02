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

  save() {
    this.clientSrv.update(this.client).subscribe((res) => {
      this.router.navigateByUrl('/client/home');
    });
  }
}
