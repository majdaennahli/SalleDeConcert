import { Evenement } from './evenement';

export class Artiste {
  constructor(
    public nomArtiste?: string,
    public nationalite?: string,
    public evenements?: Evenement,
    public imageURL?: string,
    public checked = false,
    public id?: number
  ) {}
}
