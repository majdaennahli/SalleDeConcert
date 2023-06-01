import { Time } from '@angular/common';
import { Staff } from './staff';
import { Artiste } from './artiste';
import { Local } from './local';

export class Evenement {
  constructor(
    public nom?: string,
    public artiste?: Artiste[],
    public prix?: number,
    public dateDebut?: Date,
    public heureDebut?: Time,
    public dateFin?: Date,
    public heureFin?: Time,
    public typeEvenement?: string,
    public staffs?: Staff[],
    public local?: Local,
    public id?: number
  ) {}
}
