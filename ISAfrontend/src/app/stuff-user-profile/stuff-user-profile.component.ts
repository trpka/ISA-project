import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DonationTerms } from '../model/donationTerms';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-stuff-user-profile',
  templateUrl: './stuff-user-profile.component.html',
  styleUrls: ['./stuff-user-profile.component.css']
})
export class StuffUserProfileComponent implements OnInit {

  placeholder = 'terms_id';

  id:number;
  terms_id: number;
  registeredUser: RegisteredUser;
  donationTerms: DonationTerms[];
  stuff: Stuff;

  constructor(private route: ActivatedRoute, private stuffService: StuffService) { }

  ngOnInit(): void 
  {
     this.loadProfile();
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
  /*addNegativePoint(terms_id:number)
  {
    this.stuffService.addNegativePoint(this.terms_id)
    
  }*/

  addNegativePoint(idt:number)
  {
    this.stuffService.addNegativePoint(idt)
    .subscribe(res => this.registeredUser = res)
    window.location.reload();
  }

 

}
