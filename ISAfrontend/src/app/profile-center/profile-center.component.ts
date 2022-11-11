import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
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

}
