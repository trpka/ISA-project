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
import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { Calendar } from '../model/calendar';

@Component({
  selector: 'app-stuff-survey',
  templateUrl: './stuff-survey.component.html',
  styleUrls: ['./stuff-survey.component.css']
})
export class StuffSurveyComponent implements OnInit {

  stuffSurvey: StuffSurvey;
  registeredUser: RegisteredUser;
  bloodCenter: BloodCenter;
  donationTerms: DonationTerms;
  userId: number;
  terms_id: number;
  mustFill = false;
  checkGender1 = false;
  id: number;
  p1: string;


  pickCalendar: Calendar = new Calendar({
    id: 0,
    listOfDefinedTerms: []
  });

  pickBloodCenter: BloodCenter=new BloodCenter({
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
  })

  pickUser: RegisteredUser = new RegisteredUser ({
    id:0,
    username: '' ,
    password: '' ,
    firstName: '',
    lastName: '',
    email: '',
    mobile:'',
    adress: '',
    city: '',
    state: '',
    jmbg: '',
    sex:'',
    profession:'',
    organizationInformation:'',
    enabled:false,
    points: 0,
    category:'',
    benefits:''
  })

  pickSurvey: Survey=new Survey(
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


  newDonationTerm: DonationTerms = new DonationTerms
  ({
       id: 0,
       date: new Date,
       duration: 0,
       freeTerm: false,
       reservationStart: new Date,
       reservationEnd: new Date,
       registeredUserCome: true,
       registeredUser: this.pickUser,
       calendar:  this.pickCalendar,
       survey: this.pickSurvey,
       bloodCenter: this.pickBloodCenter
  })

  
  constructor(private surveyService: SurveyService, private registerUserEditService: RegisteredUserEditService,
              private stuffService: StuffService, private donationTermService:DonationTermsService,
               private router: Router, private route: ActivatedRoute) 
  {
    

        this.stuffSurvey = new StuffSurvey
        ({
          id: 0,
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
          /*donationTerm: new DonationTerms
          ({
            id: 0,
            date: new Date,
            duration: 0,
            freeTerm: false,
            reservationStart: new Date,
            reservationEnd: new Date,
            bloodCenter: this.pickBloodCenter,
            registeredUser: this.pickUser,
            registeredUserCome: false,
            calendar: this.pickCalendar,
            survey: this.pickSurvey
          }),*/
          donationTerms: this.newDonationTerm,
            
            blood_type: "",
            accepted_exam: "",
            blood_quantity: 0,

            extra_note: "",
            reason_ejection: "",
            arm: "" 
        });
        
  }

  ngOnInit(): void 
  {
    this.findDonationTerm()
  }

  findDonationTerm()
  {
    //this.id = Number(sessionStorage.getItem('id'));
    this.id = this.route.snapshot.params['id'];
    this.donationTermService.getTermById(this.id)
    .subscribe(res => {this.donationTerms = res;
      if(this.donationTerms.registeredUser.sex == "Female")
      {
        this.checkGender1 = true;
      }
      this.stuffSurvey.donationTerms = this.donationTerms;
    })


  }

  

  save()
  {

    if(this.stuffSurvey.blood_type == '')
    {
       this.mustFill = true;
    }
    else if(this.stuffSurvey.accepted_exam == '')
    {
       this.mustFill = true;
    }
    else if(this.stuffSurvey.arm == '')
    {
       this.mustFill = true;
    } 

    
    
    
     this.stuffSurvey.id = this.pickSurvey.id;
  
     
     this.surveyService.saveStuffSurvey(this.stuffSurvey)
     .subscribe(res => this.stuffSurvey = res)
    

    }

  UpdateBloodQuantity(stuffSurvey: StuffSurvey)
  {
    this.surveyService.updateBlood(stuffSurvey)
    .subscribe(res => this.stuffSurvey = res)
    location.pathname = ('profile_center/' + this.stuffSurvey.donationTerms.bloodCenter.id);
    
  }

 
    
}

