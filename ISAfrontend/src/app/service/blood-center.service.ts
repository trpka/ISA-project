import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';


@Injectable({
  providedIn: 'root'
})
export class BloodCenterService {

  url="http://localhost:8081/api/centers";
  url1 = "http://localhost:8081/api/center"
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

/*searchByPartUsername(username:string):Observable<User>
  {
    return this.http.get<User>(`${this.url}/${username}`)
  }*/

 /* UpdateBloodCenter(bloodCenter: BloodCenter):Observable<BloodCenter>
  {
    return this.http.get<
  }*/

}
