import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css'],
})
export class ClientListComponent implements OnInit {
  clients: Client[] = [];
  filtre = '';

  constructor(private clientSrv: ClientService) {}

  clientFiltre() {
    const filtreLowerCase = this.filtre.toLowerCase();
    return this.clients.filter((f) => {
      const nomMatch = f.nom?.toLowerCase().indexOf(filtreLowerCase) !== -1;
      const loginMatch = f.login?.toLowerCase().indexOf(filtreLowerCase) !== -1;
      return nomMatch || loginMatch;
    });
  }

  ngOnInit(): void {
    this.listClients();
  }

  listClients() {
    this.clientSrv.getAll().subscribe((resultat) => {
      this.clients = resultat;
    });
  }

  deleteClient(id: number) {
    this.clientSrv.delete(id).subscribe(() => {
      this.listClients();
    });
  }
}
