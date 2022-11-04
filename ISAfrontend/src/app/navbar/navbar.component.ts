import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {  
  
  isActive: boolean = false;
  role:any;
  visiable_instrucotrs_button:boolean=false;

  constructor(public loginService: AuthenticationService) { }

  ngOnInit(): void {
  }

  /*HideInstrucotsButton(){
    this.role=sessionStorage.getItem('role');
    if(this.role=='Client'){
      this.visiable_instrucotrs_button=true;
    }else{
      this.visiable_instrucotrs_button=false;
    }
  }*/
}
