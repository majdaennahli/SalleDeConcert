import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  login = '';
  password = '';
  displayError = false;

  constructor(
    private authSrv: AuthentificationService,
    private router: Router
  ) {}

  check() {
    this.authSrv.login(this.login, this.password).subscribe({
      next: (compte) => {
        this.displayError = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        sessionStorage.setItem('compte', JSON.stringify(compte));
        if (this.verifTypeCompte()) {
          this.router.navigateByUrl('/admin/home');
        } else this.router.navigateByUrl('/client/home');
      },
      error: (err) => {
        this.displayError = true;
      },
    });
  }
  verifTypeCompte() {
    return this.authSrv.admin;
  }
}
