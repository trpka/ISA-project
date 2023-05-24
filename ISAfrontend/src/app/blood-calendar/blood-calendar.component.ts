import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterService } from '../service/blood-center.service';

import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Stuff } from '../model/stuff';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-blood-calendar',
  templateUrl: './blood-calendar.component.html',
  styleUrls: ['./blood-calendar.component.css']
})
export class BloodCalendarComponent implements OnInit {

  id:number;
  bloodCenter: BloodCenter;
  donationTerms: DonationTerms[];
  stuff: Stuff[];
  stuff1: Stuff;
  stuff_id: number;
  constructor(private route: ActivatedRoute, private router: Router, 
    private bloodCenterService: BloodCenterService, private stuffService: StuffService) 
    {
      this.stuff1 = new Stuff
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
      this.findStuffByID()
  }

  findStuffByID()
  {
    this.stuff_id = Number(sessionStorage.getItem('id'));
    this.stuffService.getStuffById(this.stuff_id)
    .subscribe(res => this.stuff1 = res);
    
  }

  loadCenter()
  {
    this.id = this.route.snapshot.params['id'];
    this.bloodCenterService.getBloodCenterById(this.id)
    .subscribe(res => this.bloodCenter = res)
  }

  ViewTermsForThisProfileCenter()
  {
    this.bloodCenterService.getAllTermsByCentre(this.id)
    .subscribe(res => this.donationTerms = res)
  }

  FindProfileByButton(user_id:number)
  {
    location.pathname = ('stuff_user_profile/' + user_id);

  }

  back()
  {
    //this.router.navigate(['create-term']);
    this.router.navigate(['stuff_edit/' +this.stuff1.id]);
  }

}