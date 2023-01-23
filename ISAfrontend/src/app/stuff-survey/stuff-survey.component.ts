import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Survey } from '../model/survey';
import { StuffSurvey } from '../model/surveyStuff';
import { DonationTermsService } from '../service/donation-terms.service';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';
import { StuffService } from '../service/stuff.service';
import { SurveyService } from '../service/survey.service';


@Component({
  selector: 'app-stuff-survey',
  templateUrl: './stuff-survey.component.html',
  styleUrls: ['./stuff-survey.component.css']
})
export class StuffSurveyComponent implements OnInit {

  stuffSurvey: StuffSurvey;
  registeredUser: RegisteredUser;
  bloodCenter: BloodCenter;
  donationTerm: DonationTerms;
  userId: number;
  terms_id: number;
  mustFill = false;
  checkGender1 = false;
  id: number;
  p1: string;

  
  


  constructor(private surveyService: SurveyService, private registerUserEditService: RegisteredUserEditService,
              private stuffService: StuffService, private donationTermService:DonationTermsService,
               private router: Router, private route: ActivatedRoute) 
  {
    /*this.registeredUser = new RegisteredUser({
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

    this.bloodCenter = new BloodCenter({
      id:0,
      centerName: "",
      address:  "",
      city:  "",
      startWork:  "",
      endWork:  "",
      description: "",
      averageGradeCentre: 0,
      bloodA: 0,
      bloodB:  0,
      bloodAB: 0,
      bloodO: 0,
      //freeAppointments:DonationTerms[];
      listOfStuffs: []
  })

      this.donationTerm = new DonationTerms
      ({
          id: 0,
          date: new Date,
          duration: 0,
          free: true,
          reservationStart: new Date,
          reservationEnd: new Date,
          bloodCenter: this.bloodCenter,
          registeredUser: this.registeredUser,
          registeredUserCome: true
        }),*/

        this.stuffSurvey = new StuffSurvey
        ({
          Survey: new Survey
          ({
            id: 0,
            numberOfDonator: "",
            date: "",
            firstName: "",
            lastName: "",
            jmbg: "",
            dateOfBirth: "",
            sex: "",
            adress: "",
            township : "",
            city: "",
            mobile: "",
            company: "",
            profession: "",
            numberOfBoodDonations: "",
            registeredUser: new RegisteredUser 
            ({
              id: 0,
              username: "",
              password: "",
              firstName: "",
              lastName: "",
              email: "",
              mobile: "",
              adress: "",
              city:  "",
              state: "",
              jmbg: "",
              sex: "",
              profession: "",
              organizationInformation: "",
              enabled: true,
              points: 0,
              category: "",
              benefits: ""
              

            }),

            p1: "",
            p2: "",
            p3: "",
            p4: "",
            p5: "",
            p6: "",
            p7: "",
            p8: ""
          }),
            p1: "",
            p2: "",
            p3: "",
            p4: "",
            p5: "",
            p6: "",
            p7: "",
            p8: ""
        });
        
  }

  ngOnInit(): void 
  {
    this.findDonationTerm()
    this.findSurveyById();
  }

  findDonationTerm()
  {
    //this.id = Number(sessionStorage.getItem('id'));
    this.id = this.route.snapshot.params['id'];
    this.donationTermService.getTermById(this.id)
    .subscribe(res => {this.donationTerm = res;
      if(this.donationTerm.registeredUser.sex == "Female")
      {
        this.checkGender1 = true;
      }
    })

    this.stuffSurvey.Survey.id = 1;
    
  }

  findSurveyById()
  {
    //this.id = Number(sessionStorage.getItem('id'));
    this.surveyService.getSurveyByID(1)
    .subscribe(res => {this.stuffSurvey.Survey = res;
      if(this.stuffSurvey.Survey.registeredUser.sex == "Female")
      {
        this.checkGender1 = true;
      }
    })
    
  }

  save()
  {
    
    
    this.donationTerm.registeredUser.id = this.stuffSurvey.Survey.id;
    this.donationTerm.registeredUser.firstName = this.stuffSurvey.Survey.firstName;
    
   
    this.stuffSurvey.p1 = this.stuffSurvey.Survey.p1;
    this.stuffSurvey.p2 = this.stuffSurvey.Survey.p2;
    this.stuffSurvey.p3 = this.stuffSurvey.Survey.p3;
    this.stuffSurvey.p4 = this.stuffSurvey.Survey.p4;
    this.stuffSurvey.p5 = this.stuffSurvey.Survey.p5;
    this.stuffSurvey.p6 = this.stuffSurvey.Survey.p6;
    this.stuffSurvey.p7 = this.stuffSurvey.Survey.p7;
    this.stuffSurvey.p8 = this.stuffSurvey.Survey.p8;

    
    

   
      //this.stuffSurvey.id = this.donationTerm.registeredUser.id;
      /*this.stuffSurvey.bloodA = this.donationTerm.bloodCenter.bloodA;
      this.stuffSurvey.bloodB = this.donationTerm.bloodCenter.bloodB;
      this.stuffSurvey.bloodAB = this.donationTerm.bloodCenter.bloodAB;
      this.stuffSurvey.bloodO = this.donationTerm.bloodCenter.bloodO;*/
     




      this.surveyService.saveStuffSurvey(this.stuffSurvey)
      .subscribe()
      
      window.location.reload();

    

  }
    
}
