import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';


@Injectable({
  providedIn: 'root'
})
export class BloodCenterService {

  url="http://localhost:8081/api/centers";
  url1 = "http://localhost:8081/api/center";

  url3="http://localhost:8081/api/centers/terms";

  url2= "http://localhost:8081/api/centerName";

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




findByName(name:string):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('name',name);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}



  UpdateBloodCenter(bloodCenter: BloodCenter):Observable<BloodCenter>
  {

    return this.http.put<BloodCenter>(this.url+"/edit", bloodCenter);
  }




findByCity(city:string):Observable<BloodCenter[]>{
  const params:HttpParams=new HttpParams().append('city',city);
  return this.http.get<BloodCenter[]>(this.url2,{params});
}

findByGradeAddress(averageGrade:number,address:string):Observable<BloodCenter[]>{
    
  const params=new HttpParams()
    .set('averageGrade',averageGrade)
    .set('address',address);
    return this.http.get<BloodCenter[]>(this.url2,{params});
}
}
