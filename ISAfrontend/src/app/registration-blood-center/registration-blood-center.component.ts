import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { BloodCenterService } from '../service/blood-center.service';

@Component({
  selector: 'app-registration-blood-center',
  templateUrl: './registration-blood-center.component.html',
  styleUrls: ['./registration-blood-center.component.css']
})
export class RegistrationBloodCenterComponent implements OnInit {

  newBloodCenter : BloodCenter;

  constructor(private BloodCenterService:BloodCenterService, private router: Router ) { 
    this.newBloodCenter = new BloodCenter({
        id:0,
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

  ngOnInit(): void {
  }

  saveBloodCenter(){
    this.BloodCenterService.SaveBloodCenter(this.newBloodCenter)
    .subscribe()
  }
}
