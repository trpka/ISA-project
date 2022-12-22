import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';
import { DefinedDonationTerms } from '../model/definedDonationTerms';



@Component({
  selector: 'app-create-donation-term',
  templateUrl: './create-donation-term.component.html',
  styleUrls: ['./create-donation-term.component.css']
})


export class CreateDonationTermComponent implements OnInit {

  
  //newTerm : DefinedDonationTerms;

  newTerm: DefinedDonationTerms = new DefinedDonationTerms({
    date: '',
    reservationStart: '',
    duration: 0
    

  })
  constructor(private router: Router,private route: ActivatedRoute,private DonationTermsService: DonationTermsService) { 
    
   }
  
  ngOnInit(): void {
  }


  // addDonationTerm(){
  //   this.DonationTermsService.AddTerm(this.donationTerm)
  //   .subscribe()
  // }

  addDonationTerm()
  { 
    console.log('janko',this.newTerm);
    this.DonationTermsService.AddTerm(this.newTerm)
    .subscribe(res => this.newTerm = res);
   // window.location.reload();
  }


}
