import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';

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
  scheduleDonationTerm:ScheduleDonationTerm;


  constructor(private route: ActivatedRoute,private donationTermsService: DonationTermsService, 
    private bloodCenterService: BloodCenterService, private router: Router) 
  {
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0
    })
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
  }

  viewTermsByCentre()
  {
    this.id = this.route.snapshot.params['id'];
    

    this.bloodCenterService.getAllFreeTermsByCentre(this.id)
    .subscribe(res => {this.donationTerms = res;})

    
  }
   
  sortByDate()
  {
    this.id = Number(this.route.snapshot.params['id']);
    this.donationTermsService.getAllDonationTermsSortedByDate(this.id)
    .subscribe(res => {this.donationTerms = res;})
  }

  scheduleTerm(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    this.donationTermsService.scheduleTerm(this.scheduleDonationTerm)
    .subscribe(_=>this. viewTermsByCentre())
  }

  goToScheduledAppointments()
  {
    this.router.navigate(['scheduled-appointments', this.id]);
  }

  goToCenter()
  {
    this.router.navigate(['profile_center', this.id]);
  }


}


