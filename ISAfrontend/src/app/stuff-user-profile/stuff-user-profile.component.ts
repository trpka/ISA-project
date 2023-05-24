import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { ActivatedRoute, Router } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { StuffService } from '../service/stuff.service';
import { BloodCenter } from '../model/bloodCenter';

@Component({
  selector: 'app-stuff-user-profile',
  templateUrl: './stuff-user-profile.component.html',
  styleUrls: ['./stuff-user-profile.component.css']
})
export class StuffUserProfileComponent implements OnInit {



  placeholder = 'terms_id';
  placeholder1 = 'terms_id';

  id:number;
  terms_id: any;
  registeredUser: RegisteredUser;
  donationTerms: DonationTerms[];
  donationTerm: DonationTerms;
  stuff: Stuff;
  user_id: number;
  stuff_id: number;

  constructor(private route: ActivatedRoute, private router: Router,
    private stuffService: StuffService) 
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
     this.loadProfile();
     this.findStuffByID();
  }

  loadProfile()
  {
    this.id = this.route.snapshot.params['id'];
    this.stuffService.getUserById(this.id)
    .subscribe(res => this.registeredUser = res)
  }

  ViewTermsForThisUser()
  {
    this.stuffService.getAllTermsByUser(this.id)
    .subscribe(res => this.donationTerms = res)
  }

  //Dodavanje Negativnog Poena Za Korisnika
  
  addNegativePoint(donationTerm: DonationTerms)
  {
    this.stuffService.addNegativePoint(donationTerm)
    .subscribe(res => this.donationTerm = res)

    if(donationTerm.registeredUserCome == true)
    {
      alert("You CAN NOT GIVE NEGATIVE POINT! USER COME TO TERM!");
    }
    else
    {
      alert("Aded a negative point for user!");
      window.location.reload();
   }

  }

  //Promena Statusa da li je korisnik dosao na pregled
  UpdateExam(donationTerm:DonationTerms)
  {
    this.stuffService.updateExam(donationTerm)
    .subscribe(res => this.donationTerm = res)
    window.location.reload();
  }

  //Prelazak na Zakazivanje Termina Za korisnika
  CreateAppointmentByUserId()
  {

      location.pathname = ('stuff_survey/'+ this.terms_id);
      // this.router.navigate(['stuff_survey/' + this.terms_id]);
      //alert("You can not create report! Patient not comming!");
  }

  findStuffByID()
  {
    this.stuff_id = Number(sessionStorage.getItem('id'));
    this.stuffService.getStuffById(this.stuff_id)
    .subscribe(res => this.stuff = res);
    
  }

  back()
  {
   
    this.router.navigate(['stuff_edit/' +this.stuff.id]);
  }



 
  

}
