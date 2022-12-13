import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = "http://localhost:8081/users/signup/async";
  constructor( private http: HttpClient) { }

  sendEmail(newUser: User): Observable<User> {
    return this.http.post<User>(this.url, newUser);
}
}
