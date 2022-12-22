import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationTerms } from '../model/donationTerms';
import { DefinedDonationTerms } from '../model/definedDonationTerms';

@Injectable
({
  providedIn: 'root'
})

export class DonationTermsService 
{

  url = "http://localhost:8081/api/terms";
  
  constructor(private http:HttpClient) { }

  getAllDonationTerms():Observable<DonationTerms[]>
  {
    return this.http.get<DonationTerms[]>(this.url);
  }

  AddTerm(donationTerm: DefinedDonationTerms):Observable<DefinedDonationTerms>
  {
    console.log('marko',donationTerm);
    return this.http.put<DefinedDonationTerms>(this.url+'/addTerm', donationTerm);
  }


}
