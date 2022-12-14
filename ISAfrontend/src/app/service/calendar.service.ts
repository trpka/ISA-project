import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Calendar } from '../model/calendar';
import { DonationTerms } from '../model/donationTerms';


@Injectable({
  providedIn: 'root'
})


export class CalendarService {

  url = "http://localhost:8081/api/calendars";
  url1="http://localhost:8081/api/calendars/terms";

  constructor(private http:HttpClient) { }

  getAllCalendars():Observable<Calendar[]>
  {
    return this.http.get<Calendar[]>(this.url);
  }

  getCalendarById(id:number):Observable<Calendar>
{
  return this.http.get<Calendar> (`${this.url}/${id}`)
}

getAllTermsByCalendar(id:number):Observable<DonationTerms[]>
{
  return this.http.get<DonationTerms[]> (`${this.url1}/${id}`)
}


}
