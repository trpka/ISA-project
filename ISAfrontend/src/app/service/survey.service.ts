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
  url2A =  "http://localhost:8081/api/update-blood";
  
  date : Survey;
  constructor(private http:HttpClient) { }

  setDate(newDate: any) {
    this.date = newDate;
  }

  getDate() {
    return this.date;
  }

  save(survey:Survey):Observable<Survey>{
    return this.http.post<Survey>(this.url,survey);
  }

  //Student 3 koristi delove ovog servisa
  saveStuffSurvey(stuffSurvey: StuffSurvey):Observable<StuffSurvey>
  {
     return this.http.post<StuffSurvey>(this.url1A,stuffSurvey);
     
  }

  //Pronalazak Surveya po ID-ju
  getSurveyByID(id:number):Observable<Survey>
  {
  return this.http.get<Survey> (`${this.url}/${id}`)
  }

  // Azuriranje Kolicine Krvi koja se nalazi u centru
  updateBlood(stuffSurvey: StuffSurvey):Observable<StuffSurvey>
  {
    return this.http.post<StuffSurvey>(this.url2A,stuffSurvey);
  }
  
}
