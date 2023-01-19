import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationTerms } from '../model/donationTerms';

import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';


@Injectable
({
  providedIn: 'root'
})

export class DonationTermsService 
{

  url = "http://localhost:8081/api/terms";

  url1A = "http://localhost:8081/api/term";

  url1 = "http://localhost:8081/api/schedule-term";
  url2 = "http://localhost:8081/api/cancel-term";
  url3= "http://localhost:8081/api/findAvaliableTerms/"
  url4 = "http://localhost:8081/api/schedule-new-term";
  url5="http://localhost:8081/api/create-new-term"
  
  constructor(private http:HttpClient) { }

  getAllDonationTerms():Observable<DonationTerms[]>
  {
    return this.http.get<DonationTerms[]>(this.url);
  }
//admin
  AddTerm(donationTerm: DefinedDonationTerms):Observable<DefinedDonationTerms>
  {
    console.log('marko',donationTerm);
    return this.http.put<DefinedDonationTerms>(this.url+'/addTerm', donationTerm);
  }

 


  //Pretraga Termina po ID-ju
  getTermById(id:number):Observable<DonationTerms>
  {
    return this.http.get<DonationTerms>(`${this.url1A}/${id}`)
  }



  /*getAllDonationTermsSortedByDate(id:number):Observable<DonationTerms[]>{
    return this.http.get<DonationTerms[]>(this.url1, id);
  }*/
  getAllDonationTermsSortedByDate(id:number):Observable<DonationTerms[]>{
    const params:HttpParams=new HttpParams().append('id',id);
    return this.http.get<DonationTerms[]>(this.url+"/sort-by-date",{params});
  }

 scheduleTerm(scheduleDonationTerm: ScheduleDonationTerm): Observable<DonationTerms> {
     return this.http.put<DonationTerms>(this.url1 , scheduleDonationTerm)
  }

  scheduleNewTerm(scheduleDonationTerm: ScheduleDonationTerm): Observable<DonationTerms> {
    return this.http.put<DonationTerms>(this.url4 , scheduleDonationTerm)
 }
 
  cancelTerm(scheduleDonationTerm: ScheduleDonationTerm): Observable<DonationTerms> {
    return this.http.put<DonationTerms>(this.url2 , scheduleDonationTerm)
  }
  
  findAllAvailableTerms(userTerm:string):Observable<DonationTerms[]>{
    return this.http.get<DonationTerms[]>(this.url3 + userTerm);

  }

  



}
