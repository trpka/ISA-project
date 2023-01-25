import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DonationTermsComponent } from '../donation-terms/donation-terms.component';
import { RegisteredUser } from '../model/registeredUser';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { ScheduleDonationTerm1 } from '../model/ScheduleDonationTerm1';
import { Survey } from '../model/survey';
import { PopUpSuccessfullyMakeAppointmentComponent } from '../pop-up-successfully-make-appointment/pop-up-successfully-make-appointment.component';
import { DonationTermsService } from '../service/donation-terms.service';
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
  registeredUserId : number;
  donationTermId : any;
  scheduleDonationTerm1:ScheduleDonationTerm1;
  data: any;
  
  constructor(private surveyService:SurveyService, private registeredUserEditService:RegisteredUserEditService, 
    private router: Router, private donationTermsService: DonationTermsService, private dialogRef: MatDialog) { 
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
        registeredUser : new RegisteredUser({
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
        p1:"",
        p2:"",
        p3:"",
        p4:"",
        p5:"",
        p6:"",
        p7:"",
        p8:""
        
      }),
      this.scheduleDonationTerm1 = new ScheduleDonationTerm1({
        donationTermId:0,
        registeredUserId: 0,
        survey : new Survey(
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
            registeredUser : new RegisteredUser({
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
            p1:"",
            p2:"",
            p3:"",
            p4:"",
            p5:"",
            p6:"",
            p7:"",
            p8:""
            
          })
      }),
      this.data = this.donationTermsService.getData();

  }

  ngOnInit(): void {
    this.findRegisteredUser();
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
      const now = formatDate(new Date());
      this.registeredUserId = Number(sessionStorage.getItem('id')); 
      this.survey.date = String(now);
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
      this.survey.registeredUser = this.registeredUser;


      this.scheduleDonationTerm1.registeredUserId =  Number(sessionStorage.getItem('id')); 
      this.scheduleDonationTerm1.donationTermId = this.data
      this.scheduleDonationTerm1.survey = this.survey;
      this.donationTermsService.scheduleTerm(this.scheduleDonationTerm1)
      .subscribe()
      const dialogRef= this.dialogRef.open(PopUpSuccessfullyMakeAppointmentComponent);
      dialogRef.afterClosed().subscribe(res=>{
        this.router.navigate(['future-terms']);
      })
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

function padTo2Digits(num: number) {
  return num.toString().padStart(2, '0');
}

function formatDate(date: Date) {
  return (
    [
      date.getFullYear(),
      padTo2Digits(date.getMonth() + 1),
      padTo2Digits(date.getDate()),
    ].join('-') +
    ' ' +
    [
      padTo2Digits(date.getHours()),
      padTo2Digits(date.getMinutes()),
      padTo2Digits(date.getSeconds()),
    ].join(':')
  );
}
