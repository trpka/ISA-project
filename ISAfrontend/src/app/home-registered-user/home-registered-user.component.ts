import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodCenter } from '../model/bloodCenter';
import { RegisteredUser } from '../model/registeredUser';
import { BloodCenterService } from '../service/blood-center.service';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';

@Component({
  selector: 'app-home-registered-user',
  templateUrl: './home-registered-user.component.html',
  styleUrls: ['./home-registered-user.component.css']
})
export class HomeRegisteredUserComponent implements OnInit {

  bloodCenters : BloodCenter[];
  registeredUser : RegisteredUser;
  userId:number;
  bloodCenterId : number;
  constructor(private bloodCenterService:BloodCenterService,  private registeredUserEditService:RegisteredUserEditService
    ,private router: Router) {
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
    this.registeredUser = new RegisteredUser({
      id:0,
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      email: "",
      mobile:"",
      adress: "",
      city: "",
      state: "",
      jmbg: "",
      sex: "",
      profession: "",
      organizationInformation: "",
      enabled: true,
      points: 0,
      category: "",
      benefits:""
    })
   }

  ngOnInit(): void {
    this.findAll();
    this.findRegisteredUser();
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

  findRegisteredUser() {
    this.userId = Number(sessionStorage.getItem('id'));
    this.registeredUserEditService.getRegisteredUserById(this.userId)
    .subscribe(res=>this.registeredUser=res);
  }

  goToBloodCenter(bloodCenter:BloodCenter){
  
    this.router.navigate(['profile_center', bloodCenter.id]);
  }

  goToRegUser(registeredUser:RegisteredUser){
  
    this.router.navigate(['regUser_edit', registeredUser.id]);
  }

  viewHistoryTerms(){
    this.router.navigate(['history-terms']);    
  }

}
