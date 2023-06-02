import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Local } from '../models/local';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LocalService {
  private static URL: string = 'http://localhost:8080/salleDeConcert/api/local';

  constructor(private httpClient: HttpClient) {}

  public getLocaux(): Observable<Local[]> {
    return this.httpClient.get<Local[]>(LocalService.URL);
  }

  public getById(id: number): Observable<Local> {
    return this.httpClient.get<Local>(`${LocalService.URL}/${id}`);
  }

  public getByIdWithEvenements(id: number): Observable<Local> {
    return this.httpClient.get<Local>(`${LocalService.URL}/${id}/evenements`);
  }

  public create(Local: Local): Observable<Local> {
    return this.httpClient.post<Local>(LocalService.URL, Local);
  }

  public update(Local: Local): Observable<Local> {
    return this.httpClient.put<Local>(`${LocalService.URL}/${Local.id}`, Local);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${LocalService.URL}/${id}`);
  }
}
