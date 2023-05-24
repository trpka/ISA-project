import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Stuff } from '../model/stuff';
import { BloodCenterService } from '../service/blood-center.service';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-profile-center',
  templateUrl: './profile-center.component.html',
  styleUrls: ['./profile-center.component.css']
})
export class ProfileCenterComponent implements OnInit 
{

  id:number;
  bloodCenter: BloodCenter;
  donationTerms: DonationTerms[];
  stuff: Stuff[];
  stuff1: Stuff;
  stuff_id: number;

  constructor(private route: ActivatedRoute, private bloodCenterService: BloodCenterService,
    private stuffService: StuffService, private router: Router ) 
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
    this.findStuffByID();
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

  UpdateBloodCenter()
  {
    this.bloodCenterService.UpdateBloodCenter(this.bloodCenter)
    .subscribe(res => this.bloodCenter = res)
    alert("Successfully created changes on Blood Center Profile!");
    window.location.reload();
  }

  //Prikaz Termina Na ovoj stranici
  ViewTermsForThisProfileCenter()
  {
    this.bloodCenterService.getAllTermsByCentre(this.id)
    .subscribe(res => this.donationTerms = res)
  }

  //Prikaz Svih Termina Vezanih za Centar na zasebnoj stranici
  ViewTerms()
  {
    location.pathname = ('donation_terms/' + this.id);
  }

  showStuffs()
  {
    this.bloodCenterService.getAllStuffsByCentre(this.id)
    .subscribe(res => this.stuff = res)
  }

  createFastReservation()
  {
      location.pathname = ('add_fast_reservation');
  }

  seeCalendar()
  {
    location.pathname = ('blood_calendar/' + this.id);
  }

  back()
  {
   
    this.router.navigate(['stuff_edit/' +this.stuff1.id]);
  }

 

}
