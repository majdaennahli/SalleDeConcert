import { Component, Input } from '@angular/core';
import { Artiste } from 'src/app/models/artiste';
import { ArtisteService } from 'src/app/services/artiste.service';

@Component({
  selector: 'app-artiste-list',
  templateUrl: './artiste-list.component.html',
  styleUrls: ['./artiste-list.component.css'],
})
export class ArtisteListComponent {
  artistes: Artiste[] = [];
  filtre = '';

  constructor(private artisteSrv: ArtisteService) {}

  artisteFiltre() {
    Input();
    return this.artistes.filter(
      (f) =>
        f.nomArtiste?.indexOf(this.filtre) != -1 ||
        f.nationalite?.indexOf(this.filtre) != -1
    );
  }

  ngOnInit(): void {
    this.listArtistes();
  }

  listArtistes() {
    this.artisteSrv.getArtistes().subscribe((resultat) => {
      this.artistes = resultat;
    });
  }

  deleteArtiste(id: number) {
    this.artisteSrv.deleteById(id).subscribe(() => {
      this.listArtistes();
    });
  }
}
