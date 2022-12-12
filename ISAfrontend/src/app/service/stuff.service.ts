import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';

@Injectable({
  providedIn: 'root'
})
export class StuffService 
{
   url = "http://localhost:8081/api/stuff";
   url1A = "http://localhost:8081/api/regUsers";
   

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

  //Prikaz Svih Registrovanih korisnika
  getAllRegisteredUsers():Observable<RegisteredUser[]>
  {
    return this.http.get<RegisteredUser[]>(this.url1A);
  }

  //Pretraga korisnika po ID-u
  getUserById(id:number): Observable<RegisteredUser>
  {
    return this.http.get<RegisteredUser>(`${this.url1A}/${id}`);
  }

  /*getUserById(id:number):Observable<RegisteredUser>
  {
    const params:HttpParams=new HttpParams().append('id',id);
    return this.http.get<RegisteredUser>(this.url1A,{params});
  }*/

  

}

