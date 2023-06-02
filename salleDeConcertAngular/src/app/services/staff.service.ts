import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Staff } from '../models/staff';

@Injectable({
  providedIn: 'root',
})
export class StaffService {
  private static URL: string = 'http://localhost:8080/salleDeConcert/api/staff';

  constructor(private httpClient: HttpClient) {}

  public getStaffs(): Observable<Staff[]> {
    return this.httpClient.get<Staff[]>(StaffService.URL);
  }

  public getById(id: number): Observable<Staff> {
    return this.httpClient.get<Staff>(`${StaffService.URL}/${id}`);
  }

  public getByIdWithEvenements(id: number): Observable<Staff> {
    return this.httpClient.get<Staff>(`${StaffService.URL}/${id}/evenements`);
  }

  public create(Staff: Staff): Observable<Staff> {
    return this.httpClient.post<Staff>(StaffService.URL, Staff);
  }

  public update(Staff: Staff): Observable<Staff> {
    return this.httpClient.put<Staff>(`${StaffService.URL}/${Staff.id}`, Staff);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${StaffService.URL}/${id}`);
  }
}
