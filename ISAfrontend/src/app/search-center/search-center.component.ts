import { Component, OnInit,Output,EventEmitter} from '@angular/core';
import { Observable } from 'rxjs';
import { BloodCenter } from '../model/bloodCenter';
import { BloodCenterService } from '../service/blood-center.service';

@Component({
  selector: 'app-search-center',
  templateUrl: './search-center.component.html',
  styleUrls: ['./search-center.component.css']
})
export class SearchCenterComponent implements OnInit {


    centerName: string;
    address: string;
    city: string;
    averageGradeCentre:number;

  

    bloodCenters : BloodCenter[];
  constructor(private bloodCenterService:BloodCenterService) {
   
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
  }

 
  findByCity(city:string){
    this.bloodCenterService.findByCity(city)
    .subscribe(res=>this.bloodCenters=res)
  }

  findByGradeAddress(averageGradeCentre:number,address:string){
    this.bloodCenterService.findByGradeAddress(averageGradeCentre,address)
    .subscribe(res=>this.bloodCenters=res)
  }
 
}
