import { Component, OnInit } from '@angular/core';
import { DonationTermsService } from '../service/donation-terms.service';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { BloodCenterService } from '../service/blood-center.service';
import { BloodCenter } from '../model/bloodCenter';



@Component({
  selector: 'app-search-avaliable-terms',
  templateUrl: './search-avaliable-terms.component.html',
  styleUrls: ['./search-avaliable-terms.component.css']
})
export class SearchAvaliableTermsComponent implements OnInit {

  avaliableTerms: any;
  userTerm:string;
  scheduleDonationTerm:ScheduleDonationTerm;
  bloodCenters:BloodCenter[];
  constructor(private donationTermsService: DonationTermsService, private bloodCenterService: BloodCenterService) {
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0
    })
   }

  ngOnInit(): void {
    console.log('hhhhhhhh')
    // this.donationService.findAllAvailableTerms("2023-02-17T07:10")
    // .subscribe(res => this.avaliableTerms=res);
   // this.donationService.findAllAvailableTerms("2023-02-17T07:10");
  }

  getFreeTerms() {
    this.donationTermsService.findAllAvailableTerms(this.userTerm)
    .subscribe(res => this.avaliableTerms=res);
  }

  goToSurvey(id:number) {
    
    this.scheduleTerm(id);
  }

  scheduleTerm(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    console.log(donationTermId);
    this.donationTermsService.scheduleTerm(this.scheduleDonationTerm)
    .subscribe()
  }

 
}
