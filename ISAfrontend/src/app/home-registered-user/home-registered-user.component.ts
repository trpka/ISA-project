import { Component, OnInit } from '@angular/core';
import { BloodCenter } from '../model/bloodCenter';
import { BloodCenterService } from '../service/blood-center.service';

@Component({
  selector: 'app-home-registered-user',
  templateUrl: './home-registered-user.component.html',
  styleUrls: ['./home-registered-user.component.css']
})
export class HomeRegisteredUserComponent implements OnInit {

  bloodCenters : BloodCenter[];
  constructor(private bloodCenterService:BloodCenterService) {
    /*this.bloodCenter = new BloodCenter({
      user : new User({
      id: 0,
      firstName: "",
      lastName: "",
      email: "",
      username: "",
      password: "",
      dateOfBirth: "" 
      }) ,
      id:number,
      centerName:string,
      address:string,
      skills:[],
      privateProfile: true,
      followers : []
    }),*/
   }

  ngOnInit(): void {
    this.findAll();
    //this.sortByName();
  }

  findAll(){
    this.bloodCenterService.getAllBloodCenters()
    .subscribe(res=>this.bloodCenters=res)
  }

  sortByName(){
    this.bloodCenterService.getAllBloodCentersSortedByName()
    .subscribe(res=>this.bloodCenters=res)
  }

  sortByCity(){
    this.bloodCenterService.getAllBloodCentersSortedByCity()
    .subscribe(res=>this.bloodCenters=res)
  }

  sortByAverageGrade(){
    this.bloodCenterService.getAllBloodCentersSortedByAverageGrade()
    .subscribe(res=>this.bloodCenters=res)
  }
}
