import { Evenement } from './evenement';

export class Local {
  constructor(
    public nom?: string,
    public evenements?: Evenement[],
    public placesPMR?: number,
    public placesAssises?: number,
    public placesFosse?: number,
    public imageURL?: string,
    public id?: number
  ) {}
}
