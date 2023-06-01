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
}
