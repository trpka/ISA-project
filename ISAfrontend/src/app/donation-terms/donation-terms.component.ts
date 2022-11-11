import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';

@Component({
  selector: 'app-donation-terms',
  templateUrl: './donation-terms.component.html',
  styleUrls: ['./donation-terms.component.css']
})
export class DonationTermsComponent implements OnInit 
{
  id: any;
  broj: number;
  donationTerms: DonationTerms[];
  bloodCenter: BloodCenter[];


  constructor(private route: ActivatedRoute,private donationTermsService: DonationTermsService, 
    private bloodCenterService: BloodCenterService) 
  {

  }

  ngOnInit(): void 
  {
     //this.viewAll();
    this.viewTermsByCentre();
   
  }

  
  viewAll()
  {
     this.donationTermsService.getAllDonationTerms()
    .subscribe(res => this.donationTerms = res)
    //this.bloodCenterService.getAllTermsByCentre(this.id)
    //.subscribe(res => this.donationTerms)
  }

  viewTermsByCentre()
  {
    this.id = this.route.snapshot.params['id'];
    

    this.bloodCenterService.getAllTermsByCentre(this.id)
    .subscribe(res => {this.donationTerms = res;})

    
  }
   
  


}


