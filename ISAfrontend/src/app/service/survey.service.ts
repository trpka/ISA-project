import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Survey } from '../model/survey';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {

  url="http://localhost:8081/api/survey";

  constructor(private http:HttpClient) { }

  save(survey:Survey):Observable<Survey>{
    return this.http.post<Survey>(this.url,survey);
  }
}
