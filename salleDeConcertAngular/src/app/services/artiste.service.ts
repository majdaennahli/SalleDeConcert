import { Injectable } from '@angular/core';
import { Artiste } from '../models/artiste';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArtisteService {
  constructor(private httpClient: HttpClient) {}

  public getArtistes(): Observable<Artiste[]> {
    return this.httpClient.get<Artiste[]>(
      'http://localhost:8080/salledeconcert/api/artiste'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/salledeconcert/api/artiste/${id}`
    );
  }

  public create(artiste: Artiste): Observable<Artiste> {
    return this.httpClient.post<Artiste>(
      'http://localhost:8080/salledeconcert/api/artiste',
      artiste
    );
  }

  public getById(id: number): Observable<Artiste> {
    return this.httpClient.get<Artiste>(
      `http://localhost:8080/salledeconcert/api/artiste/${id}`
    );
  }

  public update(artiste: Artiste): Observable<Artiste> {
    return this.httpClient.put<Artiste>(
      `http://localhost:8080/salledeconcert/api/artiste/${artiste.id}`,
      artiste
    );
  }
}
