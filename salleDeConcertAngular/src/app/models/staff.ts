import { Evenement } from 'src/app/models/evenement';
export class Staff {
  constructor(
    public nom?: string,
    public evenements?: Evenement[],
    public id?: number
  ) {}
}
