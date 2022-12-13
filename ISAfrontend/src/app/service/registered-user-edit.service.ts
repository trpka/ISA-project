import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisteredUser } from '../model/registeredUser';


@Injectable({
  providedIn: 'root'
})
export class RegisteredUserEditService {

  url = "http://localhost:8081/api/regUsers";
  url2 = "http://localhost:8081/api/registeredUsersFirstName";
  url3 = "http://localhost:8081/api/registeredUsersLastName";
  url4 = "http://localhost:8081/api/confirm-registration-register-user";

  constructor(private http:HttpClient) { }

  getRegisteredUserById(id:number): Observable<RegisteredUser>
  {
    return this.http.get<RegisteredUser> (`${this.url}/${id}`)
  }

  UpdateRegisteredUser(registeredUser: RegisteredUser):Observable<RegisteredUser>
  {
      return this.http.put<RegisteredUser>(this.url+"/edit",registeredUser);
  }

  getAllRegisteredUsers():Observable<RegisteredUser[]>{
    return this.http.get<RegisteredUser[]>(this.url);
}

findByFirstName(firstName:string):Observable<RegisteredUser[]>{
  const params:HttpParams=new HttpParams().append('firstName',firstName);
  return this.http.get<RegisteredUser[]>(this.url2,{params});
}

findByLastName(lastName:string):Observable<RegisteredUser[]>{
  const params:HttpParams=new HttpParams().append('lastName',lastName);
  return this.http.get<RegisteredUser[]>(this.url3,{params});
}

activateById(id: number): Observable<RegisteredUser> {
  return this.http.get<RegisteredUser>(`${this.url4}/${id}`);
}

}
