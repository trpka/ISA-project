import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { Stuff } from '../model/stuff';
import { RegistrationStuffService } from '../service/registration-stuff.service';

@Component({
  selector: 'app-registration-stuff',
  templateUrl: './registration-stuff.component.html',
  styleUrls: ['./registration-stuff.component.css']
})
export class RegistrationStuffComponent implements OnInit {

  mustfill:string;
  mustfillp:string;
  differentPasswords = false;
  newUser:Stuff;
  password1:string;

  constructor(private registrationStuffService:RegistrationStuffService, private router: Router) 
  {
      this.newUser = new Stuff
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
    
  }

  registration()
  {
    if(this.newUser.lastName==''){
      //console.log("prazno je")
      this.mustfill="required";
      //console.log(this.mustfill);
    }
    else if (this.newUser.firstName=='') {
      this.mustfill="required";
    }
    else if (this.newUser.email=='') {
    this.mustfill="required";
    }
    /*else if (this.newUser.password=='') {
      this.mustfill="required";
    }
    else if (this.password1=='') {
      this.mustfill="required";
    }*/
    else if (this.newUser.mobile=='') {
      this.mustfill="required";
    }
    else if (this.newUser.adress=='') {
      this.mustfill="required";
    }
    else if (this.newUser.city=='') {
      this.mustfill="required";
    }
    else if (this.newUser.state=='') {
      this.mustfill="required";
    }
    /*else if (this.newUser.jmbg=='') {
      this.mustfill="required";
    }*/
    else if (this.newUser.profession=='') {
      this.mustfill="required";
    }
    else if (this.newUser.organizationInformation=='') {
      this.mustfill="required";
    }
    else if (this.newUser.password!=this.password1) {
      this.differentPasswords=true;
    }
    else{
      console.log(this.newUser)
      this.newUser.role = "Stuff"
      this.newUser.username = this.newUser.email;
      this.registrationStuffService.registration(this.newUser)
      .subscribe();
    }

  }

}
