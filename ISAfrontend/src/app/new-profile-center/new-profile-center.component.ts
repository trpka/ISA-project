import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { Calendar } from '../model/calendar';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { RegisteredUser } from '../model/registeredUser';
import { DatePipe } from '@angular/common';
import { DonationTermsComponent } from '../donation-terms/donation-terms.component';
import { MatDialog } from '@angular/material/dialog';
import { PopUpCannotReservateTermComponent } from '../pop-up-cannot-reservate-term/pop-up-cannot-reservate-term.component';
import { PopUpCanReservateTermComponent } from '../pop-up-can-reservate-term/pop-up-can-reservate-term.component';
import { Survey } from '../model/survey';
import { PopUpRegisteredUserHaveThreePenaltiesComponent } from '../pop-up-registered-user-have-three-penalties/pop-up-registered-user-have-three-penalties.component';

@Component({
  selector: 'app-new-profile-center',
  templateUrl: './new-profile-center.component.html',
  styleUrls: ['./new-profile-center.component.css']
})
export class NewProfileCenterComponent implements OnInit {

  id:number;
  bloodCenter: BloodCenter;
  newUser: RegisteredUser;
  donationTerms: DonationTerms[];
  term: string;
  scheduleDonationTerm:ScheduleDonationTerm;
  newCenter:BloodCenter;
  newCalendar:Calendar;
  newTerm: DefinedDonationTerms;
  date1:string;
  date : Survey;
  newSurvey:Survey;
  donationTerm : DonationTerms;
 

  constructor(private datePipe: DatePipe,private route: ActivatedRoute, private bloodCenterService: BloodCenterService,
    private donationTermsService: DonationTermsService , private dialogRef: MatDialog, private router: Router) { 
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0,
      surveyId: 0
    }),
    this.donationTerm = new DonationTerms({
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
      registeredUser:new RegisteredUser({
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
      registeredUserCome: false,
      calendar: new Calendar({
        id: 0,
        listOfDefinedTerms: []
      }),
      survey: new Survey(
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
      })
    this.date = this.donationTermsService.getData();
  }

  ngOnInit(): void 
  {
    this.loadCenter();
    console.log(sessionStorage.getItem("currentUser"));

    this.term=history.state.term;
    
  
  }

  loadCenter()
  {
    this.id = this.route.snapshot.params['id'];
    this.bloodCenterService.getBloodCenterById(this.id)
    .subscribe(res => this.bloodCenter = res)
  }

  UpdateBloodCenter()
  {
    this.bloodCenterService.UpdateBloodCenter(this.bloodCenter)
    .subscribe(res => this.bloodCenter = res)
    window.location.reload();
  }

  //Prikaz Termina Na ovoj stranici
  ViewTermsForThisProfileCenter()
  {
    this.bloodCenterService.getAllTermsByCentreAndTerm(this.id,this.term)
    .subscribe(res => 
      { console.log(res)
        this.donationTerms = res})
  }

  //Prikaz Svih Termina Vezanih za Centar na zasebnoj stranici
  ViewTerms()
  {
    location.pathname = ('donation_terms/' + this.id);
  }



 
  scheduleTerm(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    console.log(donationTermId);
    this.donationTermsService.scheduleNewTerm(this.scheduleDonationTerm)
    .subscribe()
    alert("Successfully scheduled term!");
  }

  isUserGaveBloodInLast6MonthOrHave3Penalties(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.donationTermsService.isUserGaveBloodInLast6Month(this.scheduleDonationTerm.registeredUserId)
    .subscribe(res=>{
      this.donationTermsService.setData(donationTermId);
      if(res.banGaveBlood==true){
        this.dialogRef.open(PopUpCannotReservateTermComponent)
      }else if(res.banPenalties == true){
        this.dialogRef.open(PopUpRegisteredUserHaveThreePenaltiesComponent)
      }
      else{
        const dialogRef= this.dialogRef.open(PopUpCanReservateTermComponent);
        dialogRef.afterClosed().subscribe(res=>{
          this.router.navigate(['questionnaire']);
        })
        
      }
    })
  }


  
  CreateNewTerm(){

    const pom=new Date(this.term)
    pom.setMinutes(pom.getMinutes()+30)
    console.log(pom)
    this.date1=<string>this.datePipe.transform(pom,'yyyy-MM-ddThh:mm')
    

    this.newCalendar=  new Calendar({
      id: 2,
      listOfDefinedTerms: []
    });
  
    this.newCenter=new BloodCenter({
      id:this.id,
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

    const userId= <any>sessionStorage.getItem("id");
    console.log(userId);

    this.newUser= new RegisteredUser ({
      id:<number>userId,
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

    this.newSurvey=new Survey(
      {
        id: 3,
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
  
    this.newTerm= new DefinedDonationTerms({
      date: this.term,
      reservationStart: this.term,
      reservationEnd:this.date1,
      free:false,
      duration: 30,
      registeredUser: this.newUser,
      calendar: this.newCalendar,
      bloodCenter : this.newCenter,   
      survey: this.newSurvey 
  
    })

    this.donationTermsService.AddTerm(this.newTerm)
    .subscribe(res => {this.newTerm = res;
      this.donationTerm.bloodCenter = this.newTerm.bloodCenter
      this.donationTerm.calendar = this.newTerm.calendar
      //this.donationTerm.date = String(this.newTerm.date);
      this.donationTerm.survey = this.date
      console.log(this.donationTerm.survey.id)
      console.log("dasdasda")
      console.log(this.date.id)
      this.donationTermsService.UpdateDonationTerm(this.donationTerm)
    })
    //alert("Successfully creater term!");

    this.router.navigate(['/home/registered-user']);

  }

  
}
