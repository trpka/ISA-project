import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';
import { BloodCenterService } from '../service/blood-center.service';



@Component({
  selector: 'app-create-donation-term',
  templateUrl: './create-donation-term.component.html',
  styleUrls: ['./create-donation-term.component.css']
})


export class CreateDonationTermComponent implements OnInit {

  
  donationTerm: DonationTerms;



  constructor(private route: ActivatedRoute,private DonationTermsService: DonationTermsService) { 
    
  }
  ngOnInit(): void {

  }

  // addDonationTerm(){
  //   this.DonationTermsService.AddTerm(this.donationTerm)
  //   .subscribe()
  // }

  addDonationTerm()
  {
    this.DonationTermsService.AddTerm(this.donationTerm)
    .subscribe(res => this.donationTerm = res)
    window.location.reload();
  }
}
