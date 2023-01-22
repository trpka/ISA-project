import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { Calendar } from '../model/calendar';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-new-profile-center',
  templateUrl: './new-profile-center.component.html',
  styleUrls: ['./new-profile-center.component.css']
})
export class NewProfileCenterComponent implements OnInit {

  id:number;
  bloodCenter: BloodCenter;
  donationTerms: DonationTerms[];
  term: string;
  scheduleDonationTerm:ScheduleDonationTerm;
  newCenter:BloodCenter;
  newCalendar:Calendar;
  newTerm: DefinedDonationTerms;
  date:string;

 

  constructor(private datePipe: DatePipe,private route: ActivatedRoute, private bloodCenterService: BloodCenterService,private donationTermsService: DonationTermsService ) { 
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0
    })
  }

  ngOnInit(): void 
  {
    this.loadCenter();

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


  
  CreateNewTerm(){

    const pom=new Date(this.term)
    pom.setMinutes(pom.getMinutes()+30)
    console.log(pom)
    this.date=<string>this.datePipe.transform(pom,'yyyy-MM-ddThh:mm')

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
  
    this.newTerm= new DefinedDonationTerms({
      date: this.term,
      reservationStart: this.term,
      reservationEnd:this.date,
      free:false,
      duration: 30,
      calendar: this.newCalendar,
      bloodCenter : this.newCenter,    
  
    })

    this.donationTermsService.AddTerm(this.newTerm)
    .subscribe(res =>this.newTerm = res)
    alert("Successfully creater term!");
  }

}
