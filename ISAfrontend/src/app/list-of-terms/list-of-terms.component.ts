
import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';


@Component({
  selector: 'app-list-of-terms',
  templateUrl: './list-of-terms.component.html',
  styleUrls: ['./list-of-terms.component.css']
})
export class ListOfTermsComponent implements OnInit {


  
  id: any;
  broj: number;
  donationTerms: DonationTerms[];
  bloodCenter: BloodCenter[];

  constructor(private route: ActivatedRoute,private donationTermsService: DonationTermsService, 
    private bloodCenterService: BloodCenterService) { }

  ngOnInit(): void {

    this.geAllTerms();
  }

  geAllTerms()
  {
     this.donationTermsService.getAllDonationTerms()
    .subscribe(res => this.donationTerms = res)
  }

}
