import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stuff } from '../model/stuff';

@Injectable({
  providedIn: 'root'
})
export class StuffService 
{
   url = "http://localhost:8081/api/stuff";

  constructor(private http:HttpClient) { }

  //Pronalazak Zaposlenog po ID-ju
  getStuffById(id:number): Observable<Stuff>
  {
    return this.http.get<Stuff> (`${this.url}/${id}`)
  }
  
  //Izmena Podataka o Radniku
  UpdateStuff(stuff: Stuff):Observable<Stuff>
  {
      return this.http.put<Stuff>(this.url + "/edit",stuff);
  }

}

