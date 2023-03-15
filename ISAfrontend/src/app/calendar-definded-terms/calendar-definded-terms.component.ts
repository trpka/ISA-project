import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { DonationTermsService } from '../service/donation-terms.service';
import { Calendar } from '../model/calendar';
import { CalendarService} from '../service/calendar.service';


@Component({
  selector: 'app-calendar-definded-terms',
  templateUrl: './calendar-definded-terms.component.html',
  styleUrls: ['./calendar-definded-terms.component.css']
})
export class CalendarDefindedTermsComponent implements OnInit {

  //calendars : Calendar[];
  calendar: Calendar;
  
  id:number;
  donationTerms: DonationTerms[];
 

  constructor(private route: ActivatedRoute,private router: Router, private calendarService:CalendarService) { }

  ngOnInit(): void {
    this.loadCenter();
  }

  loadCenter()
  {
    this.id = this.route.snapshot.params['id'];
    this.calendarService.getCalendarById(this.id)
    .subscribe(res => this.calendar = res)
  }

  ViewTermsForThisCalendar()
  {
    this.calendarService.getAllTermsByCalendar(this.id)
    .subscribe(res => this.donationTerms = res)
  }

  back()
  {
    //this.router.navigate(['create-term']);
    this.router.navigate(['stuff_edit/' +this.id]);
  }


}
