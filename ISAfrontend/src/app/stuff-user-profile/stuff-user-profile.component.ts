import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegisteredUser } from '../model/registeredUser';
import { Stuff } from '../model/stuff';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-stuff-user-profile',
  templateUrl: './stuff-user-profile.component.html',
  styleUrls: ['./stuff-user-profile.component.css']
})
export class StuffUserProfileComponent implements OnInit {

  id:number;
  registeredUser: RegisteredUser;
  stuff: Stuff;

  constructor(private route: ActivatedRoute, private stuffService: StuffService) { }

  ngOnInit(): void 
  {
     this.loadProfile();
  }

  loadProfile()
  {
    this.id = this.route.snapshot.params['id'];
    this.stuffService.getUserById(this.id)
    .subscribe(res => this.registeredUser = res)
  }

}
