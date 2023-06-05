import { Client } from './client';
import { Evenement } from './evenement';

export class Reservation {
  constructor(
    public prix?: number,
    public dateReserv?: Date,
    public client?: Client,
    public evenement?: Evenement,
    public nombrePlaces?: number,
    public id?: number
  ) {}
}
