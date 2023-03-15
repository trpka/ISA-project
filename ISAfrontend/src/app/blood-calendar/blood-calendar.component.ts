import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodCenterService } from '../service/blood-center.service';

import { BloodCenter } from '../model/bloodCenter';
import { DonationTerms } from '../model/donationTerms';
import { Stuff } from '../model/stuff';

@Component({
  selector: 'app-blood-calendar',
  templateUrl: './blood-calendar.component.html',
  styleUrls: ['./blood-calendar.component.css']
})
export class BloodCalendarComponent implements OnInit {

  id:number;
  bloodCenter: BloodCenter;
  donationTerms: DonationTerms[];
  stuff: Stuff[];
  constructor(private route: ActivatedRoute, private bloodCenterService: BloodCenterService) { }

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

  ViewTermsForThisProfileCenter()
  {
    this.bloodCenterService.getAllTermsByCentre(this.id)
    .subscribe(res => this.donationTerms = res)
  }

  FindProfileByButton(user_id:number)
  {
    location.pathname = ('stuff_user_profile/' + user_id);

  }

}
