import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Stuff } from '../model/stuff';
import { BloodCenterService } from '../service/blood-center.service';

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

  constructor(private route: ActivatedRoute, private bloodCenterService: BloodCenterService ) { }

  ngOnInit(): void 
  {
    this.loadCenter();
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

 

}
