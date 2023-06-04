import { Time } from '@angular/common';
import { Local } from './local';
import { Reservation } from './reservation';
import { Artiste } from './artiste';
import { Staff } from './staff';

export class Evenement {
  constructor(
    public nom?: string,
    public prix?: number,
    public dateDebut?: Date,
    public heureDebut?: Time,
    public dateFin?: Date,
    public heureFin?: Time,
    public typeEvenement?: string,
    public local?: Local,
    public reservations?: Reservation[],
    public artistes?: Artiste[],
    public staffs?: Staff[],
    public imageURL?: string,
    public id?: number
  ) {}
}
