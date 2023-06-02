import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Artiste } from 'src/app/models/artiste';
import { ArtisteService } from 'src/app/services/artiste.service';

@Component({
  selector: 'app-artiste-edit',
  templateUrl: './artiste-edit.component.html',
  styleUrls: ['./artiste-edit.component.css'],
})
export class ArtisteEditComponent {
  artiste!: Artiste;

  constructor(
    private artisteSrv: ArtisteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.artiste = new Artiste();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.artisteSrv.getById(params['id']).subscribe((res) => {
          this.artiste = res;
        });
      }
    });
  }

  save() {
    if (this.artiste.id) {
      this.artisteSrv.update(this.artiste).subscribe((res) => {
        this.router.navigateByUrl('/artiste');
      });
    } else {
      this.artisteSrv.create(this.artiste).subscribe((res) => {
        this.router.navigateByUrl('/artiste');
      });
    }
  }
}
