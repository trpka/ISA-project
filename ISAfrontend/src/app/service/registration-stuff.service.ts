import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stuff } from '../model/stuff';

@Injectable({
  providedIn: 'root'
})
export class RegistrationStuffService {
  
  url="http://localhost:8081/auth/stuffSignup";


  constructor(private http:HttpClient) {}
   
  
  registration(newUser:Stuff):Observable<Stuff>
  {
    return this.http.post<Stuff>(this.url,newUser);
  }
}
