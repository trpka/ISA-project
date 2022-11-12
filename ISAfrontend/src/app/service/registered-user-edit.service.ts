import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisteredUser } from '../model/registeredUser';


@Injectable({
  providedIn: 'root'
})
export class RegisteredUserEditService {

  url = "http://localhost:8081/api/regUsers";

  constructor(private http:HttpClient) { }

  getRegisteredUserById(id:number): Observable<RegisteredUser>
  {
    return this.http.get<RegisteredUser> (`${this.url}/${id}`)
  }

  UpdateRegisteredUser(registeredUser: RegisteredUser):Observable<RegisteredUser>
  {
      return this.http.put<RegisteredUser>(this.url+"/edit",registeredUser);
  }
}
