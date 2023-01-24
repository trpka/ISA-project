import { Component,  EventEmitter,Input,Output ,OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';
import { ScheduleDonationTerm } from '../model/ScheduleDonationTerm';
import { MatDialog } from '@angular/material/dialog';
import { PopUpCannotReservateTermComponent } from '../pop-up-cannot-reservate-term/pop-up-cannot-reservate-term.component';
import { PopUpCanReservateTermComponent } from '../pop-up-can-reservate-term/pop-up-can-reservate-term.component';

@Component({
  selector: 'app-donation-terms',
  templateUrl: './donation-terms.component.html',
  styleUrls: ['./donation-terms.component.css']
})
export class DonationTermsComponent implements OnInit 
{
  //@Input()
  //items:donationTerms[];
  //@Input()
  donationTerms: DonationTerms[];

  //@Output()
  //donationTerm:EventEmitter<number>=new EventEmitter();
  data: any;
  id: any;
  broj: number;
  bloodCenter: BloodCenter[];
  scheduleDonationTerm:ScheduleDonationTerm;


  constructor(private route: ActivatedRoute,private donationTermsService: DonationTermsService, 
    private bloodCenterService: BloodCenterService, private router: Router,private dialogRef: MatDialog) 
  {
    this.scheduleDonationTerm = new ScheduleDonationTerm({
      donationTermId:0,
      registeredUserId: 0,
      surveyId : 0
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

  isUserGaveBloodInLast6Month(donationTermId:any)
  {
    this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.donationTermsService.isUserGaveBloodInLast6Month(this.scheduleDonationTerm.registeredUserId)
    .subscribe(res=>{
      this.donationTermsService.setData(donationTermId);
      if(res==true){
        this.dialogRef.open(PopUpCannotReservateTermComponent)
      }else{
        const dialogRef= this.dialogRef.open(PopUpCanReservateTermComponent);
        dialogRef.afterClosed().subscribe(res=>{
          this.router.navigate(['questionnaire']);
        })
        
      }
    })
    
    /*this.scheduleDonationTerm.registeredUserId =  Number(sessionStorage.getItem('id')); 
    this.scheduleDonationTerm.donationTermId = Number(donationTermId);
    this.donationTermsService.scheduleTerm(this.scheduleDonationTerm)
    .subscribe(res=>{
      this. viewTermsByCentre();
      if(res==null){
        this.dialogRef.open(PopUpCannotReservateTermComponent)
      }

    })*/
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


