import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Calendar } from '../model/calendar';


@Injectable({
  providedIn: 'root'
})


export class CalendarService {

  url = "http://localhost:8081/api/calendars";

  constructor(private http:HttpClient) { }

  getAllCalendars():Observable<Calendar[]>
  {
    return this.http.get<Calendar[]>(this.url);
  }
}
