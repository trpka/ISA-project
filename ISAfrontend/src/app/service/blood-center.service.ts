import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Stuff } from '../model/stuff';


@Injectable({
  providedIn: 'root'
})
export class BloodCenterService {

  url="http://localhost:8081/api/centers";
  url1 = "http://localhost:8081/api/center";
  url2= "http://localhost:8081/api/centerName";
  url3="http://localhost:8081/api/centers/terms";
  url6="http://localhost:8081/api/centers/free/terms"
  url4="http://localhost:8081/api/centers/scheduled-terms";
  urlA = "http://localhost:8081/api/centers/stuffs";
  url5= "http://localhost:8081/api/findAvaliableCenters/"
  

  constructor(private http:HttpClient) { }

  getAllBloodCenters():Observable<BloodCenter[]>{
    return this.http.get<BloodCenter[]>(this.url);
}

getAllBloodCentersSortedByName():Observable<BloodCenter[]>{
  return this.http.get<BloodCenter[]>(this.url+"/sort-by-name");
}

getAllBloodCentersSortedByCity():Observable<BloodCenter[]>{
  return this.http.get<BloodCenter[]>(this.url+"/sort-by-city");
}

getAllBloodCentersSortedByAverageGrade():Observable<BloodCenter[]>{
  return this.http.get<BloodCenter[]>(this.url+"/sort-by-average-grade");
}

getBloodCenterById(id:number):Observable<BloodCenter>
{
  return this.http.get<BloodCenter> (`${this.url1}/${id}`)
}

//Prikaz Svih Termina Vezanih za ovaj centar
getAllTermsByCentre(id:number):Observable<DonationTerms[]>
{
  return this.http.get<DonationTerms[]> (`${this.url3}/${id}`)
}

getAllFreeTermsByCentre(id:number):Observable<DonationTerms[]>
{
  return this.http.get<DonationTerms[]> (`${this.url6}/${id}`)
}

getAllTermsByCentreAndTerm(id:number,term:string):Observable<DonationTerms[]>
{
  //return this.http.post<DonationTerms[]> (`${this.url3}/${id}`)
  return this.http.post<DonationTerms[]>(`${this.url3}/${id}`, term);
}

//OVO MENJAJ
/*getAllScheduledTermsByCentre(bloodCenterRegisteredUser:BloodCenterRegisteredUser):Observable<DonationTerms[]>
{
  return this.http.get<DonationTerms[]> (`${this.url4}/${bloodCenterRegisteredUser}`)
}*/

/*getAllScheduledTermsByCentre(bloodCenterRegisteredUser:any):Observable<DonationTerms[]>{
  const params:HttpParams=new HttpParams().append('bloodCenterRegisteredUser',bloodCenterRegisteredUser);
  return this.http.get<DonationTerms[]>(this.url4, {params});
}*/

getAllScheduledTermsByCentre(bloodCenterId:number,registeredUserId:number):Observable<DonationTerms[]>{

  const params=new HttpParams()
    .set('bloodCenterId',bloodCenterId)
    .set('registeredUserId',registeredUserId);
    return this.http.get<DonationTerms[]>(this.url4,{params});
}


getAllStuffsByCentre(id:number):Observable<Stuff[]>
{
  return this.http.get<Stuff[]>(`${this.urlA}/${id}`)
}

findByName(name:string):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('name',name);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}


  //Izmena podataka o Centru
  UpdateBloodCenter(bloodCenter: BloodCenter):Observable<BloodCenter>
  {

    return this.http.put<BloodCenter>(this.url+"/edit", bloodCenter);
  }

  SaveBloodCenter(bloodCenter: BloodCenter):Observable<BloodCenter>
  {

    return this.http.post<BloodCenter>(this.url1, bloodCenter);
  }


findByCity(city:string):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('city',city);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}


findByAddress(address:string):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('address',address);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}

findByAverageGrade(averageGradeCentre:number):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('averageGradeCentre',averageGradeCentre);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}

findByGradeAndAddress(address:string,averageGradeCenre:number):Observable<BloodCenter[]>{
    
  const params=new HttpParams()
    .set('address',address)
    .set('averageGradeCenre',averageGradeCenre);
    return this.http.get<BloodCenter[]>(this.url2,{params});
}

findAllAvailableCenters(userTerm:string):Observable<BloodCenter[]>{
  return this.http.get<BloodCenter[]>(this.url5 + userTerm);

}

findAllBloodCentersSortedByAverageGrade():Observable<BloodCenter[]>{
  return this.http.get<BloodCenter[]>(this.url5+"sort-by-average-grade");
}

}
