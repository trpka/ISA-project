import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';

@Injectable({
  providedIn: 'root'
})
export class StuffService 
{
   url = "http://localhost:8081/api/stuff";
   url1A = "http://localhost:8081/api/regUsers";
   url2A = "http://localhost:8081/api/users/terms";
   url3A = "http://localhost:8081/api/add_negative";
   

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

  getAllTermsByUser(id:number):Observable<DonationTerms[]>
  {
    return this.http.get<DonationTerms[]>(`${this.url2A}/${id}`)
  }

  //Dodeljivanje Negativnih Poena
  addNegativePoint(terms_id:number): Observable<RegisteredUser>
  {
    const params: HttpParams = new HttpParams().append('terms_id',terms_id);
    return this.http.get<RegisteredUser>(this.url3A,{params});
  }

  

}

