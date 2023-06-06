import { Component, OnInit } from '@angular/core';
import { Local } from 'src/app/models/local';
import { LocalService } from 'src/app/services/local.service';

@Component({
  selector: 'app-local-list',
  templateUrl: './local-list.component.html',
  styleUrls: ['./local-list.component.css'],
})
export class LocalListComponent implements OnInit {
  locaux!: Local[];
  filtre = '';

  constructor(private localSrv: LocalService) {}

  localFiltre() {
    const filtreLowerCase = this.filtre.toLowerCase();

    return this.locaux.filter(
      (l) => l.nom?.toLowerCase().indexOf(filtreLowerCase) != -1
    );
  }

  ngOnInit(): void {
    this.listLocaux();
  }

  listLocaux() {
    this.localSrv.getLocaux().subscribe((resultat) => {
      this.locaux = resultat;
    });
  }
}
