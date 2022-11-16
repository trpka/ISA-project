import { Component, OnInit } from '@angular/core';
import { RegisteredUser } from '../model/registeredUser';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';

@Component({
  selector: 'app-serch-registered-user',
  templateUrl: './serch-registered-user.component.html',
  styleUrls: ['./serch-registered-user.component.css']
})
export class SerchRegisteredUserComponent implements OnInit {

  placeholder1 = ' first name';
  placeholder2= 'last name';

    firstName: string;
    lastName: string;

  

    registeredUsers : RegisteredUser[];
  constructor(private registeredUserEditService:RegisteredUserEditService) {
   
   }


  ngOnInit(): void {
    this.findAll();
  }

  findAll(){
    this.registeredUserEditService.getAllRegisteredUsers()
    .subscribe(res=>this.registeredUsers=res)
  }

  findByFirstName(name:string){
    this.registeredUserEditService.findByFirstName(name)
    .subscribe(res=>this.registeredUsers=res)
  }
  
  findByLastName(name:string){
    this.registeredUserEditService.findByLastName(name)
    .subscribe(res=>this.registeredUsers=res)
  }
}
