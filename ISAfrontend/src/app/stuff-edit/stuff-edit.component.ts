import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { Stuff } from '../model/stuff';
import { Router } from '@angular/router';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-stuff-edit',
  templateUrl: './stuff-edit.component.html',
  styleUrls: ['./stuff-edit.component.css']
})
export class StuffEditComponent implements OnInit 
{

  id_centre: number;
  id: number;
  stuff: Stuff;
  bloodCenter: BloodCenter;

  placeholder = 'please enter info...';



  constructor(private route: ActivatedRoute, private router: Router,
     private stuffService: StuffService) { }

  ngOnInit(): void 
  {
    this.loadStuff();
  }

  loadStuff()
  {
     this.id = this.route.snapshot.params['id'];
     this.stuffService.getStuffById(this.id)
     .subscribe(res => this.stuff = res)
  }

  UpdateStuff()
  {
    this.stuffService.UpdateStuff(this.stuff)
    .subscribe(res => this.stuff = res)
    alert("Successfully created changes on Stuff  Profile!");
    window.location.reload();
    this.loadStuff();
  }

  ShowStuffCenter()
  {
    this.id_centre = this.route.snapshot.params['id_centre'];
    
    location.pathname = ('profile_center/' + this.stuff.bloodCenter.id);

  }

  changeOnlyPassword()
  {
    this.stuffService.ChangeOnlyPassword(this.stuff)
    .subscribe(res => this.stuff = res)
    alert("Successfully PASSWORD SWITCH!");
    window.location.reload();
    this.loadStuff();
  }

  //Svi registrovani korisnici
  AllRegisteredUsers()
  {
    location.pathname = ('all_registered_users/');
  }

  //Brza Rezervacija
  CreateFastReservation()
  {
    this.router.navigate(['add_fast_reservation']);
  }

  CreateReservation()
  {
    this.router.navigate(['create-term']);
  }

  //Prikaz Kalendara
  ShowCalendar()
  {
    this.router.navigate(['blood_calendar/' + this.stuff.bloodCenter.id]);
  }

}