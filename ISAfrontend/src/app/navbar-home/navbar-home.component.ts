import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Stuff } from '../model/stuff';
import { AuthenticationService } from '../service/authentication.service';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-navbar-home',
  templateUrl: './navbar-home.component.html',
  styleUrls: ['./navbar-home.component.css']
})
export class NavbarHomeComponent implements OnInit {

 
username: any;
  dash_url = '/';
  id: any;
  role: any;
  firstlogin: boolean;
  stuff: Stuff;

  @Output()
  LogOut: EventEmitter<void> = new EventEmitter();

  constructor(private _http: HttpClient, public stuffService: StuffService,
    private loginService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
  }

  logOut() {
    this.loginService.logOut();
    this.LogOut.next();
    this.router.navigate(['']);
  }

  showDashboard() {
    this.id = sessionStorage.getItem('id');
    this.role = sessionStorage.getItem('role');
    if (this.role == 'RegisteredUser') {
      this.router.navigate(['home/registered-user']);

    } 
   

   
  }

  

}
