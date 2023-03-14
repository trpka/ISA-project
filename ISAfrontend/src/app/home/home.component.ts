import { Component, OnInit } from '@angular/core';
import { StuffService } from '../service/stuff.service';
import { Router } from '@angular/router';
import { Stuff } from '../model/stuff';
import { BloodCenter } from '../model/bloodCenter';
import { RegisteredUser } from '../model/registeredUser';
import { User } from '../model/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  stuff: Stuff;
  stuff_id: number;
  id: number;
  registeredUser: RegisteredUser;
  registered_user_id: number;
  user: User;
loginService: any;

  constructor(private router: Router, public stuffService: StuffService) 
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


      this.registeredUser = new RegisteredUser({
        id:0,
        username: "",
        password: "",
        firstName: "",
        lastName: "",
        email: "",
        mobile:"",
        adress: "",
        city: "",
        state: "",
        jmbg: "",
        sex: "",
        profession: "",
        organizationInformation: "",
        enabled: true,
        points: 0,
        category: "",
        benefits:""
      })

  }

  ngOnInit(): void 
  {
   // this.findStuffByID();
  // this.findUserById();
  }

  findStuffByID()
  {
    //this.stuff_id = Number(sessionStorage.getItem('id'));
    this.id = Number(sessionStorage.getItem('id'));
    
    this.stuffService.getStuffById(this.id)
    .subscribe(res => this.stuff = res);
    this.checkPassword();
   
  }

  findUserById()
  {
    this.id = Number(sessionStorage.getItem('id'));
    this.stuffService.getAllUserById(this.id)
    .subscribe(res => this.user = res);
   
    this.checkUser();
  }

  checkUser()
  {
    if(this.user.role == "RegisteredUser")
    {
      this.router.navigate(['search-center']);
    }
    else
    {
      this.router.navigate(['stuff_edit/' + this.id]);
    }
  }

  checkPassword()
  {
    if(this.stuff.firstLogin == true)
    {
      this.router.navigate(['stuff_edit/' + this.id]);
    }
    else
    {
      this.router.navigate(['search-center']);
      //this.router.navigate(['']);
    }
    
  }

}
