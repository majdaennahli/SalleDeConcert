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
    public locaux?: Local[],
    public staffs?: Staff[],
<<<<<<< HEAD
    public imageURL?: string,
=======
    public artistes?: Artiste[],
>>>>>>> f75962f0fc46bab268f32739ab21399a53086de6
    public id?: number
  ) {}
}
