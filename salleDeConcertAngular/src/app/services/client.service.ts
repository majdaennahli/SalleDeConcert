import { Client } from './../models/client';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  public getById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(`${ClientService.URL}/${id}`);
  }

  public create(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(ClientService.URL, client);
  }

  public update(client: Client): Observable<Client> {
    return this.httpClient.put<Client>(
      `${ClientService.URL}/${client.id}`,
      client
    );
  }
  private static URL: string =
    'http://localhost:8080/salleDeConcert/api/client';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(ClientService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ClientService.URL}/${id}`);
  }

  public inscription(client: any): Observable<any> {
    return this.httpClient.post(`${ClientService.URL}/inscription`, client);
  }

  public loginExist(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`${ClientService.URL}/login/${login}`);
  }
}
