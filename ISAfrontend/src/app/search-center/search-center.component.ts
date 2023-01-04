import { Component, OnInit,Output,EventEmitter} from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';
import { BloodCenterService } from '../service/blood-center.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-center',
  templateUrl: './search-center.component.html',
  styleUrls: ['./search-center.component.css']
})
export class SearchCenterComponent implements OnInit {

  placeholder = 'average grade';
  placeholder1 = 'address';
  placeholder2= 'name';
  placeholder3 = 'city';

    centerName: string;
    address: string;
    city: string;
    averageGradeCentre:number;

  

    bloodCenters : BloodCenter[];
  constructor(private bloodCenterService:BloodCenterService,private route: ActivatedRoute,private router: Router) {
   
   }


  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.bloodCenterService.getAllBloodCenters()
    .subscribe(res=>this.bloodCenters=res)
  }

  findByName(name:string){
    this.bloodCenterService.findByName(name)
    .subscribe(res=>this.bloodCenters=res)
    //alert("Great! It is successfully done!");
  }

 
  findByCity(city:string){
    this.bloodCenterService.findByCity(city)
    .subscribe(res=>this.bloodCenters=res)
    //alert("Great! It is successfully done!");
  }

  findByAddress(address:string){
    this.bloodCenterService.findByAddress(address)
    .subscribe(res=>this.bloodCenters=res)
   // alert("Great! It is successfully done!");
  }

  findByAverageGrade(averageGradeCentre:number){
    this.bloodCenterService.findByAverageGrade(averageGradeCentre)
    .subscribe(res=>this.bloodCenters=res)
   // alert("Great! It is successfully done!");
  }
  // findByGradeAndAddress(address:string,averageGradeCenre:number){
    
  //   this.bloodCenterService.findByGradeAndAddress(address,averageGradeCenre)
  //   .subscribe(res=>this.bloodCenters=res)
  // }

  goToHome()
  {
    this.router.navigate(['']);
  }
 
}
