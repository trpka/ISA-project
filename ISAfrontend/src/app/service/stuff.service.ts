import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Params } from '@angular/router';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class StuffService 
{
   url =   "http://localhost:8081/api/stuff";
   url1A = "http://localhost:8081/api/regUsers";
   url2A = "http://localhost:8081/api/users/terms";
   url3A = "http://localhost:8081/api/addPenal";
   url4A = "http://localhost:8081/api/exam/edit";
   url5A = "http://localhost:8081/api/stuff/edit";
   url6A = "http://localhost:8081/api/users/centers";
   url7A = "http://localhost:8081/api/users/sort-by-name";
   url8A = "http://localhost:8081/api/users/sort-by-lastname";
   url9A = "http://localhost:8081/api/users/sort-by-id";
   url10A = "http://localhost:8081/api/user";

   
   

  constructor(private http:HttpClient) { }

  //Pronalazak Zaposlenog po ID-ju
  getStuffById(id:number): Observable<Stuff>
  {
    return this.http.get<Stuff> (`${this.url}/${id}`)
  }
  
  //Izmena Podataka o Radniku
  UpdateStuff(stuff: Stuff):Observable<Stuff>
  {
      return this.http.put<Stuff>(this.url+"/edit",stuff);
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

  //Dodeljivanje Negativnih Poena ako se ne pojavi na pregledu
  addNegativePoint(donationTerm: DonationTerms):Observable<DonationTerms>
  {

      return this.http.post<DonationTerms>(this.url3A,donationTerm);
  }

  //Oznacavanje da li je korisnik dosao na pregled
  updateExam(donationTerm: DonationTerms):Observable<DonationTerms>
  {
    return this.http.put<DonationTerms>(this.url4A, donationTerm);
  }
  //Uzimanje Samo onih korisnika koji su dali krv u odredjenom centru
  getAllUsersWhoGaveBloodInThisCentre(id:number):Observable<RegisteredUser[]>
  {
    return this.http.get<RegisteredUser[]>(`${this.url6A}/${id}`);
  }

  //Sortiranje Registrovanih Korisnika u Okviru Centra
  
  getAllUsersSortByFirstName(id:number):Observable<RegisteredUser[]>
  {
    return this.http.get<RegisteredUser[]>(`${this.url7A}/${id}`);
  }

  getAllUsersSortByLastName(id:number):Observable<RegisteredUser[]>
  {
    return this.http.get<RegisteredUser[]>(`${this.url8A}/${id}`);
  }

  getAllUsersSortById(id:number):Observable<RegisteredUser[]>
  {
    return this.http.get<RegisteredUser[]>(`${this.url9A}/${id}`);
  }

  //Uzimanje Juzera po ID-ju
  getAllUserById(id: number): Observable<User>
  {
    return this.http.get<User>(`${this.url10A}/${id}`);
  }

  //Izmena lozinke za admina kad se prvi put loguje
  changePassword(id: number, newPassword: string): Observable<Stuff> 
  {
    return this.http.post<Stuff>(`${this.url}/` + `changePassword` + `/${id}`, { newPassword });
  }

  ChangeOnlyPassword(stuff: Stuff):Observable<Stuff>
  {
      return this.http.put<Stuff>(this.url+"/edit_pass",stuff);
  }


  

 
  

}

