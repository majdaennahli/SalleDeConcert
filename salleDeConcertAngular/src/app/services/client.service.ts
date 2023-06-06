import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../models/client';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string =
    'http://localhost:8080/salleDeConcert/api/client';
  constructor(private httpClient: HttpClient) {}

  public inscription(client: Client): Observable<any> {
    return this.httpClient.post(`${ClientService.URL}/inscription`, client);
  }

  public loginExist(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`${ClientService.URL}/login/${login}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ClientService.URL}/${id}`);
  }

  public getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(ClientService.URL);
  }
  public getById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(`${ClientService.URL}/${id}`);
  }

  public getByIdWithReservations(id: number): Observable<Client> {
    return this.httpClient.get<Client>(
      `http://localhost:8080/salleDeConcert/api/client/${id}/reservations`
    );
  }
  public create(Client: Client): Observable<Client> {
    return this.httpClient.post<Client>(ClientService.URL, Client);
  }

  public update(Client: Client): Observable<Client> {
    return this.httpClient.put<Client>(
      `${ClientService.URL}/${Client.id}`,
      Client
    );
  }
}
