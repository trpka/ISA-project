import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegisteredUser } from '../model/registeredUser';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-all-registered-users',
  templateUrl: './all-registered-users.component.html',
  styleUrls: ['./all-registered-users.component.css']
})
export class AllRegisteredUsersComponent implements OnInit 
{

  placeholder1 = 'id';

   registeredUsers: RegisteredUser[];
   registeredUser: RegisteredUser;
   id: number;
   user_id: number;

  constructor(private route: ActivatedRoute, private stuffService: StuffService) 
  { 

  }

  ngOnInit(): void 
  {
      this.viewRegisteredUsers();
  }

  viewRegisteredUsers()
  {
      this.stuffService.getAllRegisteredUsers()
      .subscribe(res => this.registeredUsers = res)
  }

  FindProfileById()
  {
    // this.stuffService.getUserById(id)
     //.subscribe(res=> this.registeredUser=res)
     location.pathname = ('stuff_user_profile/' + this.id);
  }

  //Pretraga korisnika po Dugmetu u redu
  FindProfileByButton(user_id:number)
  {
    location.pathname = ('stuff_user_profile/' + user_id);

  }


  

}
