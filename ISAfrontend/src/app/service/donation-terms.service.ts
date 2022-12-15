import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DonationTerms } from '../model/donationTerms';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';

@Injectable
({
  providedIn: 'root'
})

export class DonationTermsService 
{

  url = "http://localhost:8081/api/terms";
  url1 = "http://localhost:8081/api/schedule-term";
  url2 = "http://localhost:8081/api/cancel-term";
  
  constructor(private http:HttpClient) { }

  getAllDonationTerms():Observable<DonationTerms[]>
  {
    return this.http.get<DonationTerms[]>(this.url);
  }

  AddTerm(donationTerm: DonationTerms):Observable<DonationTerms>
  {

    return this.http.put<DonationTerms>(this.url+"/addTerm", donationTerm);
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
 
  cancelTerm(scheduleDonationTerm: ScheduleDonationTerm): Observable<DonationTerms> {
    return this.http.put<DonationTerms>(this.url2 , scheduleDonationTerm)
  }
  
}
