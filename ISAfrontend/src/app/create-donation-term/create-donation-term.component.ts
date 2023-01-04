import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';
import { DefinedDonationTerms } from '../model/definedDonationTerms';
import { Calendar } from '../model/calendar';
import { BloodCenter } from '../model/bloodCenter';



@Component({
  selector: 'app-create-donation-term',
  templateUrl: './create-donation-term.component.html',
  styleUrls: ['./create-donation-term.component.css']
})


export class CreateDonationTermComponent implements OnInit {

  
  //newTerm : DefinedDonationTerms;

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

  newTerm: DefinedDonationTerms = new DefinedDonationTerms({
    date: '',
    reservationStart: '',
    reservationEnd:'',
    duration: 0,
    calendar: this.pickCalendar,
    bloodCenter : this.pickBloodCenter,    

  })
  constructor(private router: Router,private route: ActivatedRoute,private DonationTermsService: DonationTermsService) { 
    
   }
  
  ngOnInit(): void {
  }



  addDonationTerm()
  { 
    console.log('janko',this.newTerm);
    this.newTerm.calendar = this.pickCalendar;
    this.DonationTermsService.AddTerm(this.newTerm)
    .subscribe(res =>this.newTerm = res);
    alert("Successfully created a free term!");
    location.pathname = ('defined_terms/' + this.pickCalendar.id);
   // window.location.reload();
  }



}
