import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  mustfill:string;
  mustfillp:string;
  differentPasswords = false;
  newUser:User;
  users:User[];
  password1:string;

  constructor(private registrationService:RegistrationService, private router: Router) 
  {
      this.newUser = new User
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
          jmbg:"",
          sex:"",
          profession:"",
          organizationInformation:"",
          enabled:false,
          role:"",
          authorities : []
        }
      );

      this.users = [];

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
    else if (this.newUser.jmbg=='') {
      this.mustfill="required";
    }
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
      this.newUser.role = "RegisteredUser"
      this.newUser.username = this.newUser.email;
      this.registrationService.registration(this.newUser)
      .subscribe();
      this.router.navigate(['/login']);
    }

  }

}
