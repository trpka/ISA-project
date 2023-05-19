import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { RegistrationStuffService } from '../service/registration-stuff.service';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-all-registered-users',
  templateUrl: './all-registered-users.component.html',
  styleUrls: ['./all-registered-users.component.css']
})
export class AllRegisteredUsersComponent implements OnInit 
{

  placeholder1 = 'id';

   registeredUsers: RegisteredUser[];
   registeredUser: RegisteredUser;
   stuff: Stuff;
   stuff_id: number;
   id: number;
   user_id: number;

  constructor(private route: ActivatedRoute,  private stuffService: StuffService,
    private registrationStuffService:RegistrationStuffService,private router: Router) 
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
      this.findStuffByID();
      //this.viewRegisteredUsers();
  }

  findStuffByID()
  {
    this.stuff_id = Number(sessionStorage.getItem('id'));
    this.stuffService.getStuffById(this.stuff_id)
    .subscribe(res => this.stuff = res);
    this.viewRegisteredUsers();
  }

  viewRegisteredUsers()
  {

      this.stuffService.getAllUsersWhoGaveBloodInThisCentre(this.stuff.bloodCenter.id)
      .subscribe(res => this.registeredUsers = res )
  }

  FindProfileById()
  {
   
     location.pathname = ('stuff_user_profile/' + this.id);
  }

  //Pretraga korisnika po Dugmetu u redu
  FindProfileByButton(user_id:number)
  {
    location.pathname = ('stuff_user_profile/' + user_id);

  }


  //Sortiranje
  sortByFirstName()
  {
    this.stuffService.getAllUsersSortByFirstName(this.stuff.bloodCenter.id)
    .subscribe(res => this.registeredUsers = res)
   // this.viewRegisteredUsers()
  }

  sortByLastName()
  {
    this.stuffService.getAllUsersSortByLastName(this.stuff.bloodCenter.id)
    .subscribe(res => this.registeredUsers = res)
  }

  sortById()
  {
    this.stuffService.getAllUsersSortById(this.stuff.bloodCenter.id)
    .subscribe(res => this.registeredUsers = res)
  }


  

}
