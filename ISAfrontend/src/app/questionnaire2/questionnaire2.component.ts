import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { Calendar } from '../model/calendar';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { Survey } from '../model/survey';
import { DonationTermsService } from '../service/donation-terms.service';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';
import { SurveyService } from '../service/survey.service';

@Component({
  selector: 'app-questionnaire2',
  templateUrl: './questionnaire2.component.html',
  styleUrls: ['./questionnaire2.component.css']
})
export class Questionnaire2Component implements OnInit {

  registeredUser:RegisteredUser;
  userId:number;
  survey:Survey;
  mustfill = false;
  checkGender1 = false;
  registeredUserId : number;
  donationTermId : any;
  scheduleDonationTerm:ScheduleDonationTerm;
  data: any;
  donationTerm: any;
  constructor(private surveyService:SurveyService, private registeredUserEditService:RegisteredUserEditService, 
    private router: Router, private donationTermsService: DonationTermsService ) { 
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
        this.scheduleDonationTerm = new ScheduleDonationTerm({
          donationTermId:0,
          registeredUserId: 0,
          surveyId : 0
        }),
        /*this.donationTerm = new DonationTerms({
        id:0,
        date: new Date(),
        duration: 0,
        freeTerm: false,
        reservationStart: new Date(),
        reservationEnd: new Date(),
        bloodCenter:new BloodCenter({
          id:0,
          centerName: '',
          address: '',
          city: '',
          startWork: '',
          endWork: '',
          description:'',
          averageGradeCentre:0,
          bloodA:0,
          bloodB: 0 ,
          bloodAB:0,
          bloodO:0,
        listOfStuffs:[]
        }),
        registeredUser: this.registeredUser,
        registeredUserCome: false,
        calendar: new Calendar({
          id: 0,
          listOfDefinedTerms: []
        }),
        survey: this.survey
        })*/
        this.data = this.donationTermsService.getData();


    }

  ngOnInit(): void {
     //this.getTermById()
     this.findRegisteredUser() 
  }


  getTermById() {
    this.donationTerm =  this.donationTermsService.getTermById(this.data)
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
      //const now = formatDate(new Date());
      this.registeredUserId = Number(sessionStorage.getItem('id')); 
      //this.survey.date = String(now);
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
      console.log(this.survey.registeredUser.email);
      this.surveyService.save(this.survey)
        .subscribe(res => {this.survey = res;
          this.surveyService.setDate(this.survey)
        })
      //this.surveyService.save(this.survey)
      //.subscribe()
      this.router.navigate(['/avaliableCenters']);
        
    }
  }

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
