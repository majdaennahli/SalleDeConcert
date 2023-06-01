import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Local } from '../models/local';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LocalService {
  constructor(private httpClient: HttpClient) {}

  public getLocaux(): Observable<Local[]> {
    return this.httpClient.get<Local[]>(
      'http://localhost:8080/salleDeConcert/api/local'
    );
  }
  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/salleDeConcert/api/local/${id}`
    );
  }
  public create(local: Local): Observable<Local> {
    return this.httpClient.post<Local>(
      'http://localhost:8080/salleDeConcert/api/local',
      local
    );
  }
  public getById(id: number): Observable<Local> {
    return this.httpClient.get<Local>(
      `http://localhost:8080/salleDeConcert/api/local/${id}`
    );
  }
  public update(local: Local): Observable<Local> {
    return this.httpClient.put<Local>(
      `http://localhost:8080/salleDeConcert/api/local/${local.id}`,
      local
    );
  }
}
