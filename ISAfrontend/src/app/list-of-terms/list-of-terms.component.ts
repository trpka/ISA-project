
import { Component, OnInit } from '@angular/core';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


import { BloodCenterService } from '../service/blood-center.service';
import { DonationTermsService } from '../service/donation-terms.service';
import { BloodCenter } from '../model/bloodCenter';
import { Calendar } from '../model/calendar';
import { CalendarService } from '../service/calendar.service';


@Component({
  selector: 'app-list-of-terms',
  templateUrl: './list-of-terms.component.html',
  styleUrls: ['./list-of-terms.component.css']
})
export class ListOfTermsComponent implements OnInit {


  id: any;
  calendars :Calendar[];
  donationTerms: DonationTerms[];
  bloodCenter: BloodCenter[];

  constructor(private route: ActivatedRoute,private donationTermsService: DonationTermsService, 
    private bloodCenterService: BloodCenterService,private calendarService: CalendarService,private router: Router) { }

  ngOnInit(): void {

    this.geAllCalendars();
  }

  geAllCalendars()
  {
     this.calendarService.getAllCalendars()
    .subscribe(res => this.calendars = res)
  }

  // goToCalendar(){
  
  //   location.pathname = ('defined_terms/' + this.id);
  //   //this.router.navigate(['defined_terms', this.id]);
  // }



  
}
