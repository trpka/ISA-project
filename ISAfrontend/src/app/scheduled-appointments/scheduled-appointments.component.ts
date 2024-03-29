import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { PopUpDisableCancelReservationComponent } from '../pop-up-disable-cancel-reservation/pop-up-disable-cancel-reservation.component';
import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-scheduled-appointments',
  templateUrl: './scheduled-appointments.component.html',
  styleUrls: ['./scheduled-appointments.component.css']
})
export class ScheduledAppointmentsComponent implements OnInit {

  id: any;
  id2: any;
  donationTerms: DonationTerms[];
  scheduleDonationTerm:ScheduleDonationTerm;

  constructor(private route: ActivatedRoute, 
              private bloodCenterService: BloodCenterService, 
              private router: Router,
              private dialogRef: MatDialog,
              private donationTermsService: DonationTermsService) {
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0,
      surveyId : 0
    })
   }

  ngOnInit(): void {
    this.viewAllScheduledTermsByCentre();
  }

  viewAllScheduledTermsByCentre()
  {
    this.id = Number(this.route.snapshot.params['id']);
    this.id2 = Number(sessionStorage.getItem('id')); 
    
    this.bloodCenterService.getAllScheduledTermsByCentre(this.id, this.id2)
    .subscribe(res => {this.donationTerms = res;})
    
  }

  back()
  {
    this.router.navigate(['donation_terms', this.id]);
  }

  goToCenter()
  {
    this.router.navigate(['profile_center', this.id]);
  }


  cancelAppointment(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    this.donationTermsService.cancelTerm(this.scheduleDonationTerm)
    .subscribe(res=>{
      if(res==null){
        this.dialogRef.open(PopUpDisableCancelReservationComponent);
      }else{
        this. viewAllScheduledTermsByCentre();
      }
    })
  }

}
