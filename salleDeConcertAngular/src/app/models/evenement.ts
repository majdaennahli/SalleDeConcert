import { Time } from '@angular/common';

export class Evenement {
  constructor(
    public nom?: string,
    public prix?: number,
    public dateDebut?: Date,
    public heureDebut?: Time,
    public dateFin?: Date,
    public heureFin?: Time,
    public typeEvenement?: string,
    public id?: number
  ) {}
}
