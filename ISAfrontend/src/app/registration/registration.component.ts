import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  mustfill:string;
  newUser:User;
  users:User[];
  password1:string;

  constructor(private registrationService:RegistrationService) 
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

  checkPassword(){
    if(this.password1 != this.newUser.password)
    {
      console.log("password is not same")
    }
  }

  registration()
  {
    if(this.newUser.lastName==''){
      console.log("prazno je")
      this.mustfill="required";
      console.log(this.mustfill);
    }else{
      console.log(this.newUser)
      this.newUser.role = "RegisteredUser"
      this.registrationService.registration(this.newUser)
      .subscribe(_=>this.checkPassword());
    }

  }

}
