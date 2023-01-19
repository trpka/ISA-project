import { Component, OnInit } from '@angular/core';
import { RegisteredUser } from '../model/registeredUser';
import { Router } from '@angular/router';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';

@Component({
  selector: 'app-serch-registered-user',
  templateUrl: './serch-registered-user.component.html',
  styleUrls: ['./serch-registered-user.component.css']
})
export class SerchRegisteredUserComponent implements OnInit {

  id:number;
  placeholder1 = ' first name';
  placeholder2= 'last name';

    
    firstName: string;
    lastName: string;
  

    registeredUsers : RegisteredUser[];
  /*  newRegUser: RegisteredUser = new RegisteredUser({
      id: 14,
      username: '' ,
      password: '',
      firstName: '',
      lastName: '',
      email: '',
      mobile:'',
      adress: '',
      city: '',
      state: '',
      jmbg: '',
      sex:'',
      profession:'',
      organizationInformation:'',
      enabled:false,
      points: 0,
      category:'',
      benefits:'',
    });*/
  constructor(private registeredUserEditService:RegisteredUserEditService,private router: Router) {
   
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

  goToRegUser(registeredUser:RegisteredUser){
  
    this.router.navigate(['regUser_edit', registeredUser.id]);
  }
}
