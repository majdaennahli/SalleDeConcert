import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Evenement } from '../models/evenement';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class EvenementService {
  private static URL: string =
    'http://localhost:8080/salleDeConcert/api/evenement';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Evenement[]> {
    return this.httpClient.get<Evenement[]>(EvenementService.URL);
  }

  public getById(id: number): Observable<Evenement> {
    return this.httpClient.get<Evenement>(`${EvenementService.URL}/${id}`);
  }

  public create(Evenement: Evenement): Observable<Evenement> {
    return this.httpClient.post<Evenement>(EvenementService.URL, Evenement);
  }

  public update(Evenement: Evenement): Observable<Evenement> {
    return this.httpClient.put<Evenement>(
      `${EvenementService.URL}/${Evenement.id}`,
      Evenement
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${EvenementService.URL}/${id}`);
  }
}
