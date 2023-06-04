import { Artiste } from './artiste';
import { Local } from './local';
import { Staff } from './staff';

export class Evenement {
  constructor(
    public nom?: string,
    public prix?: number,
    public dateDebut?: Date,
    public dateFin?: Date,
    public heureDebut?: string,
    public heureFin?: string,
    public typeEvenement?: string,
    public local?: Local,
    public staffs?: Staff[],
    public imageURL?: string,
    public artistes?: Artiste[],
    public id?: number
  ) {}
}
