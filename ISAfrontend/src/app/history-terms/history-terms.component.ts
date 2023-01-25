import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-history-terms',
  templateUrl: './history-terms.component.html',
  styleUrls: ['./history-terms.component.css']
})
export class HistoryTermsComponent implements OnInit {
  historyTerms : DonationTerms[];
  idUser : any;
  didNotGiveBlood: boolean;
  constructor(private donationTermsService: DonationTermsService) { 
    didNotGiveBlood : false;
  }

  ngOnInit(): void {
    this.viewHistoryTerms()
  }

  viewHistoryTerms()
  {
    
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.historyTermsForRegisteredUser(this.idUser)
    .subscribe(res => {this.historyTerms = res;
      console.log(this.historyTerms)
      for(var val of res)
      { 
        if((val.freeTerm == false && val.registeredUserCome == true))
        {
          console.log(val)
          this.didNotGiveBlood= true;
        
          console.log("sdadasd" , this.didNotGiveBlood)
        }
        else
        {
          this.didNotGiveBlood = false;
        }
        
      };
    })
    
  }

  sortByDate()
  {
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.sortHistoryTermsByDate(this.idUser)
    .subscribe(res => {this.historyTerms = res;})
  }

  sortByDuration()
  {
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.sortHistoryTermsByDuration(this.idUser)
    .subscribe(res => {this.historyTerms = res;})
  }

}
