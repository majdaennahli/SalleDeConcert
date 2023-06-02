import { Component } from '@angular/core';
import { Client } from 'src/app/models/client';

@Component({
  selector: 'app-client-home',
  templateUrl: './client-home.component.html',
  styleUrls: ['./client-home.component.css'],
})
export class ClientHomeComponent {
  client!: Client;
  constructor() {
    this.ClientInfo();
  }
  ClientInfo() {
    const clientInfo = sessionStorage.getItem('compte');
    if (clientInfo) {
      this.client = JSON.parse(clientInfo);
    }
  }
}
