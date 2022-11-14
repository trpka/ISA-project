import { Component, OnInit } from '@angular/core';
import { RegisteredUser } from '../model/registeredUser';
import { Survey } from '../model/survey';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';
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
  registeredUser:RegisteredUser;
  userId:number;
  //answers: [];

  survey:Survey;
  constructor(private surveyService:SurveyService, private registeredUserEditService:RegisteredUserEditService) { 
    this.registeredUser = new RegisteredUser({
      id:0,
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      email: "",
      mobile:"",
      adress: "",
      city: "",
      state: "",
      jmbg: "",
      sex: "",
      profession: "",
      organizationInformation: "",
      enabled: true,
      points: 0,
      category: "",
      benefits:""
    }),

    this.survey=new Survey(
      {
        id: 0,
        numberOfDonator:"",
        date:"",
        firstName: this.registeredUser.firstName,
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
      })

  }

  ngOnInit(): void {
    this.findRegisteredUser()
  }

  save(){ 
    this.survey.firstName = this.registeredUser.firstName;
    this.survey.lastName = this.registeredUser.lastName;
    this.survey.jmbg = this.registeredUser.jmbg;
    this.survey.sex = this.registeredUser.sex;
    this.survey.adress = this.registeredUser.adress;
    this.survey.city = this.registeredUser.city;
    this.survey.mobile = this.registeredUser.mobile;
    this.survey.company = this.registeredUser.organizationInformation;
    this.survey.profession = this.registeredUser.profession;
    this.survey.numberOfBoodDonations = String(this.registeredUser.points);
    this.surveyService.save(this.survey)
    .subscribe()
  }

  findRegisteredUser() {
    this.userId = Number(sessionStorage.getItem('id'));
    this.registeredUserEditService.getRegisteredUserById(this.userId)
    .subscribe(res=>this.registeredUser=res);
  }
}
