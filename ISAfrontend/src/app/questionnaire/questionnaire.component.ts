import { Component, OnInit } from '@angular/core';
import { Survey } from '../model/survey';
import { SurveyService } from '../service/survey.service';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {
  id:number;
  numberOfDonator: string;
  date: string;
  firstName: string;
  lastName: string;
  jmbg: string;
  dateOfBirth:string;
  sex:string;
  adress:string;
  township: string ;
  city:string;
  mobile:string;
  company:string;
  profession: string;
  numberOfBoodDonations: string;
  p1:string;
  p2:string;
  p3:string;
  p4:string;
  //answers: [];

  survey:Survey;
  constructor(private surveyService:SurveyService) { 
    this.survey=new Survey(
      {
        id: 0,
        numberOfDonator:"",
        date:"",
        firstName: "",
        lastName: "",
        jmbg: "",
        dateOfBirth:"",
        sex:"",
        adress:"",
        township: "",
        city:"",
        mobile:"",
        company:"",
        profession: "",
        numberOfBoodDonations: "",
        p1:"",
        p2:"",
        p3:"",
        p4:""
      });
  }

  ngOnInit(): void {
  }

  save(){ 
    console.log("odgovor", this.survey.p2)
    this.surveyService.save(this.survey)
    .subscribe(res=>this.survey=res)
  }
}
