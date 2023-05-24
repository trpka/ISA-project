import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { Calendar } from '../model/calendar';
import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { AddFastDonationTerms } from '../model/fastTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { Survey } from '../model/survey';
import { DonationTermsService } from '../service/donation-terms.service';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-add-fast-reservation',
  templateUrl: './add-fast-reservation.component.html',
  styleUrls: ['./add-fast-reservation.component.css']
})
export class AddFastReservationComponent implements OnInit {

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

    pickStuff: Stuff = new Stuff
    ({
      id: 0,
          firstName:"",
          lastName: "",
          email: "",
          username:"",
          password:"",
          mobile:"",
          adress:"",
          city:"",
          state:"",
          //jmbg:"",
          //sex:"",
          profession:"",
          organizationInformation:"",
          enabled:false,
          role:"Stuff",
          //authorities : [],
          firstLogin: true,
          bloodCenter : this.pickBloodCenter

    })


    newFastTerm: AddFastDonationTerms = new AddFastDonationTerms({
      date: '',
      reservationStart: '',
      reservationEnd:'',
      free:true,
      duration: 0,
      registeredUser:this.pickUser,
      calendar: this.pickCalendar,
      bloodCenter : this.pickBloodCenter,    
      survey:this.pickSurvey,
      stuff: this.pickStuff
  
    })

    /*newFastTerm: DefinedDonationTerms = new DefinedDonationTerms({
      date: '',
      reservationStart: '',
      reservationEnd:'',
      free:true,
      duration: 0,
      registeredUser:this.pickUser,
      calendar: this.pickCalendar,
      bloodCenter : this.pickBloodCenter,    
      survey:this.pickSurvey
  
    })*/


 stuff_id: number;
 stuff: Stuff;
  constructor(private router: Router, 
    private route: ActivatedRoute, private DonationTermsService: DonationTermsService, private StuffService: StuffService) 
    {
      this.stuff = new Stuff
      (
        {
          id: 0,
          firstName:"",
          lastName: "",
          email: "",
          username:"",
          password:"",
          mobile:"",
          adress:"",
          city:"",
          state:"",
          //jmbg:"",
          //sex:"",
          profession:"",
          organizationInformation:"",
          enabled:false,
          role:"Stuff",
          //authorities : [],
          firstLogin: true,
          bloodCenter : new BloodCenter({
            id:1,
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
        }
      );
    }

  ngOnInit(): void 
  {
    this.findStuffByID();
  }

  addFastDonationTerm()
  {
    console.log('janko', this.newFastTerm);
    this.newFastTerm.calendar = this.pickCalendar;

    this.DonationTermsService.AddFastTerm(this.newFastTerm)
    .subscribe(res => this.newFastTerm = res);

    alert("Successfully created a free term!");
    location.pathname = ('defined_terms/' + this.pickCalendar.id);
  }

  findStuffByID()
  {
    this.stuff_id = Number(sessionStorage.getItem('id'));
    this.StuffService.getStuffById(this.stuff_id)
    .subscribe(res => this.stuff = res);
    
  }

  back()
  {
   
    this.router.navigate(['stuff_edit/' +this.stuff.id]);
  }

}
