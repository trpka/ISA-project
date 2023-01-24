import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators,FormControl } from '@angular/forms';
import { ActivatedRoute,Router } from '@angular/router';
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
 


 editable: boolean=false;

  constructor(private route: ActivatedRoute, private registeredUserService: RegisteredUserEditService,private router: Router) {

    this.registeredUser = new RegisteredUser ({
      id:0,
      username: '' ,
      password: '' ,
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
      benefits:''
    })
   }

  
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
    alert("Successfully update!");
    window.location.reload();
  }

  back()
  {
    this.router.navigate(['home/registered-user']);
  }
  
}
