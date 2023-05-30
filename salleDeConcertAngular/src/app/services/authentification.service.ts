import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  private static URL: string = 'http://localhost:8080/salleDeConcert/api/auth';
  constructor(private httpClient: HttpClient) {}

  public login(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get(AuthentificationService.URL, {
      headers: headers,
    });
  }
  public get client(): boolean {
    if (sessionStorage.getItem('compte')) {
      let compte = JSON.parse(sessionStorage.getItem('compte')!);
      return compte.role === 'CLIENT';
    }
    return false;
  }
  public get admin(): boolean {
    if (sessionStorage.getItem('compte')) {
      let compte = JSON.parse(sessionStorage.getItem('compte')!);
      return compte.role === 'ADMIN';
    }
    return false;
  }
}
