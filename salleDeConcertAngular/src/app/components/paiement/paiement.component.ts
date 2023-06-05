import { Component, NgModule, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css'],
})
export class PaiementComponent implements OnInit {
  form!: FormGroup;
  dateNow: Date = new Date();
  expiration: string =
    this.dateNow.getFullYear() +
    '-' +
    (this.dateNow.getMonth() + 1).toString().padStart(2, '0');

  constructor() {}

  ngOnInit(): void {
    this.form = new FormGroup({
      porteur: new FormControl('', Validators.required),
      numcarte: new FormControl('', Validators.required),
      expiration: new FormControl('', Validators.required),
      code: new FormControl('', Validators.required),
    });
  }

  submit() {}
}
