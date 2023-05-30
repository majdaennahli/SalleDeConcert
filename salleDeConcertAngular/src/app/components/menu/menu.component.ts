import { AuthentificationService } from 'src/app/services/authentification.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  constructor(
    private router: Router,
    private authSrv: AuthentificationService
  ) {}
  get login() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).login;
    }
  }

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }
  verifTypeCompte() {
    return this.authSrv.admin;
  }
}
