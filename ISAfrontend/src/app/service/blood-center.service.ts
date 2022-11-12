import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';


@Injectable({
  providedIn: 'root'
})
export class BloodCenterService {

  url="http://localhost:8081/api/centers";
  url1 = "http://localhost:8081/api/center";
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


}
