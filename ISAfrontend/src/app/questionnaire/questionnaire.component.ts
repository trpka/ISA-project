import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  
  registeredUser:RegisteredUser;
  userId:number;
  survey:Survey;
  mustfill = false;
  checkGender1 = false;
  //answers: [];

  
  constructor(private surveyService:SurveyService, private registeredUserEditService:RegisteredUserEditService, private router: Router) { 
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
        p4:"",
        p5:"",
        p6:"",
        p7:"",
        p8:""
      })

  }

  ngOnInit(): void {
    this.findRegisteredUser()
    //this.checkGender()
  }

  save(){ 
    if(this.survey.p1==''){
      this.mustfill=true;
    }
    else if (this.survey.p2=='') {
      this.mustfill=true;
    }
    else if (this.survey.p3=='') {
      this.mustfill=true;
    }
    else if (this.survey.p4=='') {
      this.mustfill=true;
    }
    else if (this.survey.p5=='') {
      this.mustfill=true;
    }
    else if (this.survey.p6=='') {
      this.mustfill=true;
    }
    else if (this.survey.p7=='') {
      this.mustfill=true;
    }
    else if (this.survey.p8=='' && this.registeredUser.sex == "Female") {
      this.mustfill=true;
    }
    else{
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
      this.router.navigate(['/home/registered-user']);
    }
  }

  /*checkGender():boolean{
    if(this.registeredUser.sex = "Female")
      {
        this.checkGender1 = true;
      }
      return this.checkGender1;
    
    
  }*/

  findRegisteredUser() {
    this.userId = Number(sessionStorage.getItem('id'));
    this.registeredUserEditService.getRegisteredUserById(this.userId)
    .subscribe(res=>{this.registeredUser=res;
        if(this.registeredUser.sex == "Female")
        {
          this.checkGender1 = true;
        }
    })
  }

}
