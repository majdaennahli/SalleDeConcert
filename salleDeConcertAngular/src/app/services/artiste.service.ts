import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artiste } from '../models/artiste';

@Injectable({
  providedIn: 'root',
})
export class ArtisteService {
  private static URL: string =
    'http://localhost:8080/salleDeConcert/api/artiste';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Artiste[]> {
    return this.httpClient.get<Artiste[]>(ArtisteService.URL);
  }

  public getById(id: number): Observable<Artiste> {
    return this.httpClient.get<Artiste>(`${ArtisteService.URL}/${id}`);
  }

  public create(Artiste: Artiste): Observable<Artiste> {
    return this.httpClient.post<Artiste>(ArtisteService.URL, Artiste);
  }

  public update(Artiste: Artiste): Observable<Artiste> {
    return this.httpClient.put<Artiste>(
      `${ArtisteService.URL}/${Artiste.id}`,
      Artiste
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ArtisteService.URL}/${id}`);
  }
}
