import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RegisteredUser } from '../model/registeredUser';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';



@Component({
  selector: 'app-registered-user-edit',
  templateUrl: './registered-user-edit.component.html',
  styleUrls: ['./registered-user-edit.component.css'],
  
  
})
export class RegisteredUserEditComponent implements OnInit {

  id: number;
  registeredUser: RegisteredUser;
  


  placeholder = 'please enter info...';


  constructor(private route: ActivatedRoute, private registeredUserService: RegisteredUserEditService) { }

  ngOnInit(): void {
    this.loadStuff();


  
  }



  loadStuff()
  {
     this.id = this.route.snapshot.params['id'];
     this.registeredUserService.getRegisteredUserById(this.id)
     .subscribe(res => this.registeredUser = res)
  }
  
  UpdateRegisteredUser()
  {
    this.registeredUserService.UpdateRegisteredUser(this.registeredUser)
    .subscribe(res => this.registeredUser = res)
    window.location.reload();
  }

  
}
