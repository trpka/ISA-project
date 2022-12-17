import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationTerms } from '../model/donationTerms';

@Injectable
({
  providedIn: 'root'
})

export class DonationTermsService 
{

  url = "http://localhost:8081/api/terms";
  url1A = "http://localhost:8081/api/term";
  
  constructor(private http:HttpClient) { }

  getAllDonationTerms():Observable<DonationTerms[]>
  {
    return this.http.get<DonationTerms[]>(this.url);
  }

  AddTerm(donationTerm: DonationTerms):Observable<DonationTerms>
  {

    return this.http.put<DonationTerms>(this.url+"/addTerm", donationTerm);
  }

  //Pretraga Termina po ID-ju
  getTermById(id:number):Observable<DonationTerms>
  {
    return this.http.get<DonationTerms>(`${this.url1A}/${id}`)
  }


}
