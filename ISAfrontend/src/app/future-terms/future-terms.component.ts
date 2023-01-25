import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { PopUpDisableCancelReservationComponent } from '../pop-up-disable-cancel-reservation/pop-up-disable-cancel-reservation.component';
import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-future-terms',
  templateUrl: './future-terms.component.html',
  styleUrls: ['./future-terms.component.css']
})
export class FutureTermsComponent implements OnInit {

  futureTerms : DonationTerms[];
  idUser : any;
  scheduleDonationTerm:ScheduleDonationTerm;
  id: any;
  id2: any;
  //donationTerms: DonationTerms[];
  constructor(private donationTermsService: DonationTermsService, 
              private route: ActivatedRoute,
              private bloodCenterService: BloodCenterService,
              private dialogRef: MatDialog) { 
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0,
      surveyId : 0
    })
  }

  ngOnInit(): void {
    this.viewHistoryTerms();
  }

  viewHistoryTerms()
  {
    
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.futureTermsForRegisteredUser(this.idUser)
    .subscribe(res => {this.futureTerms = res;
      console.log(this.futureTerms);
    })
    
  }

  resetFutureTerms(){
    this.idUser = Number(sessionStorage.getItem('id')); 
    this.donationTermsService.futureTermsForRegisteredUser(this.idUser)
    .subscribe(res => {this.futureTerms = res;
      console.log(this.futureTerms);
    })
  }

  cancelAppointment(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    this.donationTermsService.cancelTerm(this.scheduleDonationTerm)
    .subscribe(res=>{
      console.log("dsada",res)
      if(res==null){
        this.dialogRef.open(PopUpDisableCancelReservationComponent);
      }else{
        this.resetFutureTerms();
      }
    })
  }

}
