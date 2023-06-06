import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { ClientService } from 'src/app/services/client.service';
import { CustomValidator } from 'src/app/validators/custom-validator';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientSrv: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        [
          Validators.required,
          CustomValidator.pasChaineDefinieParLUtilisateur('tutu'),
        ],
        this.loginLibre()
      ),
      passwordGrp: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*\W).{4,}$/
              ///^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%?&])[A-Za-z\d@$!%?&]{4,}$/
            ),
          ]),
          confirmPassword: new FormControl(),
        },
        this.controlsEgaux
      ),
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      telephone: new FormControl('', Validators.required),
      dateNaissance: new FormControl(
        this.getCurrentDate(),
        Validators.required
      ),
    });
  }

  loginLibre(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientSrv.loginExist(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { loginExist: true } : null;
        })
      );
    };
  }

  controlsEgaux(control: AbstractControl): ValidationErrors | null {
    return control.get('password')?.value ==
      control.get('confirmPassword')?.value
      ? null
      : { pasEgaux: true };
  }

  submit() {
    let client = {
      prenom: this.form.get('prenom')?.value,
      nom: this.form.get('nom')?.value,
      telephone: this.form.get('telephone')?.value,
      naissance: this.form.get('dateNaissance')?.value,

      login: this.form.get('login')?.value,
      password: this.form.get('passwordGrp.password')?.value,
    };
    this.clientSrv.inscription(client).subscribe((client) => {
      console.debug(client);
      this.router.navigateByUrl('/login');
    });
  }

  getCurrentDate(): string {
    const today = new Date();
    const year = today.getFullYear();
    const month = ('0' + (today.getMonth() + 1)).slice(-2);
    const day = ('0' + today.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
  }
}
