import { Component, NgModule, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css'],
})
export class PaiementComponent implements OnInit {
  form!: FormGroup;

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
