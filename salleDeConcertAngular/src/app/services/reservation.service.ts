import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL: string =
    'http://localhost:8080/salleDeConcert/api/reservation';

  constructor(private httpClient: HttpClient) {}

  public getReservation(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(ReservationService.URL);
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(`${ReservationService.URL}/${id}`);
  }

  public create(Reservation: Reservation): Observable<Reservation> {
    return this.httpClient.post<Reservation>(
      ReservationService.URL,
      Reservation
    );
  }

  public update(Reservation: Reservation): Observable<Reservation> {
    return this.httpClient.put<Reservation>(
      `${ReservationService.URL}/${Reservation.id}`,
      Reservation
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ReservationService.URL}/${id}`);
  }

  // public getByClientId(id: number): Observable<Reservation> {
  //   return this.httpClient.get<Reservation[]>(`${ReservationService.URL}/${id}/client`);
  // }
}
