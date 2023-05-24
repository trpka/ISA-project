import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { DonationTermsService } from '../service/donation-terms.service';
import { Calendar } from '../model/calendar';
import { CalendarService} from '../service/calendar.service';
import { Stuff } from '../model/stuff';
import { BloodCenter } from '../model/bloodCenter';
import { StuffService } from '../service/stuff.service';


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
  stuff: Stuff;
  stuff_id: number;
 

  constructor(private route: ActivatedRoute,private router: Router, 
    private calendarService:CalendarService, private stuffService: StuffService) 
    { 
      this.stuff = new Stuff
      (
        {
          id: 0,
          firstName:"",
          lastName: "",
          email: "",
          username:"",
          password:"",
          mobile:"",
          adress:"",
          city:"",
          state:"",
          //jmbg:"",
          //sex:"",
          profession:"",
          organizationInformation:"",
          enabled:false,
          role:"Stuff",
          //authorities : [],
          firstLogin: true,
          bloodCenter : new BloodCenter({
            id:1,
            centerName: "",
            address:  "",
            city:  "",
            startWork:  "",
            endWork:  "",
            description: "",
            averageGradeCentre: 0,
            bloodA: 0,
            bloodB:  0,
            bloodAB: 0,
            bloodO: 0,
            //freeAppointments:DonationTerms[];
            listOfStuffs: []
            })
        }
      );

    }

  ngOnInit(): void 
  {
    this.loadCenter();
    this.findStuffByID();
  }

  findStuffByID()
  {
    this.stuff_id = Number(sessionStorage.getItem('id'));
    this.stuffService.getStuffById(this.stuff_id)
    .subscribe(res => this.stuff = res);
    
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
    this.router.navigate(['stuff_edit/' +this.stuff.id]);
  }


}
