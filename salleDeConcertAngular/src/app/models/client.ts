import { Reservation } from './reservation';

export class Client {
  constructor(
    public login?: string,
    public prenom?: string,
    public nom?: string,
    public naissance?: Date,
    public telephone?: string,
    public reservation?: Reservation,
    public id?: number
  ) {}
}
