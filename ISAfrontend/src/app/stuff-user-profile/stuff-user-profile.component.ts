import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

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
  placeholder1 = 'user_id';

  id:number;
  terms_id: any;
  registeredUser: RegisteredUser;
  donationTerms: DonationTerms[];
  donationTerm: DonationTerms;
  stuff: Stuff;
  user_id: number;

  constructor(private route: ActivatedRoute, 
    private stuffService: StuffService) { }

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
  
  addNegativePoint(donationTerm: DonationTerms)
  {
    //this.donationTerm.id = Number(sessionStorage.getItem('id'))
    this.stuffService.addNegativePoint(donationTerm)
    .subscribe(res => this.donationTerm = res)
    window.location.reload();
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
    location.pathname = ('stuff_survey/'+ this.terms_id)
  }



 
  

}
