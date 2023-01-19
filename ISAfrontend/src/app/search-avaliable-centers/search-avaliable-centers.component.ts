import { Component, OnInit } from '@angular/core';
import { BloodCenterService } from '../service/blood-center.service';
import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Router } from '@angular/router';
import { DonationTermsService } from '../service/donation-terms.service';

@Component({
  selector: 'app-search-avaliable-centers',
  templateUrl: './search-avaliable-centers.component.html',
  styleUrls: ['./search-avaliable-centers.component.css']
})
export class SearchAvaliableCentersComponent implements OnInit {
  id:number;
  avaliableCenters: any;
  userTerm:string;
  bloodCenter:BloodCenter;
  bloodCenters: BloodCenter[];
  donationTerms: DonationTerms[];
  constructor( private bloodCenterService: BloodCenterService,private router: Router,private donationTermsService: DonationTermsService) { }

  ngOnInit(): void {
    console.log('hhhhhhhh')
  }

  getFreeCenters() {
    this.bloodCenterService.findAllAvailableCenters(this.userTerm)
    .subscribe(res => this.avaliableCenters=res.sort((a,b)=>b.averageGradeCentre-a.averageGradeCentre));
  }


  sortByAverageGrade(){
    this.avaliableCenters=this.avaliableCenters.sort((a: any,b :any)=>a.averageGradeCentre-b.averageGradeCentre)
  }
  
  goToBloodCenter(bloodCenter:BloodCenter){
  
    this.router.navigate(['new_profile_center', bloodCenter.id],{
      state: {
        term:this.userTerm,
        id: bloodCenter.id
      },});
  }

  
}
