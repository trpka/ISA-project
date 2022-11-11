import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-donation-terms',
  templateUrl: './donation-terms.component.html',
  styleUrls: ['./donation-terms.component.css']
})
export class DonationTermsComponent implements OnInit 
{
  donationTerms: DonationTerms[];

  constructor(private donationTermsService: DonationTermsService) 
  {

  }

  ngOnInit(): void 
  {
    this.viewAll();
  }

  viewAll()
  {
    this.donationTermsService.getAllDonationTerms()
    .subscribe(res => this.donationTerms = res)
  }

}
