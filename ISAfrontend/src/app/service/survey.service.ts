import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Survey } from '../model/survey';
import { StuffSurvey } from '../model/surveyStuff';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {

  url="http://localhost:8081/api/survey";
  url1A = "http://localhost:8081/api/stuff-survey";
  

  constructor(private http:HttpClient) { }

  save(survey:Survey):Observable<Survey>{
    return this.http.post<Survey>(this.url,survey);
  }

  ///Student 3 koristi delove ovog servisa
  saveStuffSurvey(stuffSurvey: StuffSurvey):Observable<StuffSurvey>
  {
    return this.http.post<StuffSurvey>(this.url1A,stuffSurvey);
  }

  //Pronalazak Surveya po ID-ju
  getSurveyByID(id:number):Observable<Survey>
  {
  return this.http.get<Survey> (`${this.url}/${id}`)
  }
}
