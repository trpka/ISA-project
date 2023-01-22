import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-future-terms',
  templateUrl: './future-terms.component.html',
  styleUrls: ['./future-terms.component.css']
})
export class FutureTermsComponent implements OnInit {

  futureTerms : DonationTerms[];
  idUser : any;
  constructor(private donationTermsService: DonationTermsService) { 
  
  }

  ngOnInit(): void {
    this.viewHistoryTerms()
  }

  viewHistoryTerms()
  {
    
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.futureTermsForRegisteredUser(this.idUser)
    .subscribe(res => {this.futureTerms = res;
      console.log(this.futureTerms);
    })
    
  }

}
