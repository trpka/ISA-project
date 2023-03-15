import { Component,EventEmitter, OnInit ,  Output} from '@angular/core';
import { Router } from '@angular/router';
import { Stuff } from '../model/stuff';
import { User } from '../model/user';
import { AuthenticationService } from '../service/authentication.service';
import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser:User;
  username: any;
  password = '';
  invalidLogin = false;
  error:string='';
  idLoginUser:any;
  loggedUser: Boolean;
  stuff: Stuff;
  @Output()
  LogIn: EventEmitter<void> = new EventEmitter();
  constructor(private router: Router,
    private loginservice: AuthenticationService, private stuffService: StuffService) { 

  }

  ngOnInit(): void {
  }

 
  login() {
    if (this.username == '' || this.password == '')
      this.error = "Username and password must be filled out";
    else {
      this.loginservice.authenticate(this.username, this.password).subscribe(
        (data: any) => {
          console.log(data)
          this.LogIn.next();
          this.idLoginUser = sessionStorage.getItem('id');
          //this.router.navigate(['']);
          this.findUserById();

         /* if(this.idLoginUser != 5)
          {
            this.router.navigate(['']);
          }
          else
          {
            this.router.navigate(['change_password']);
          }*/

          if(this.newUser.role == 'RegisteredUser')
          {
            this.router.navigate(['']);
          }
          else if(this.newUser.role == 'Stuff')
          {
            this.findStuffById();

            if(this.stuff.firstLogin == true)
            {
              this.router.navigate(['change_password']);
            }
            else
            {
              this.router.navigate(['/stuff_edit/' + this.stuff.id]);
            }
          }

          
          
          this.invalidLogin = false
        },
        (error: { message: string | null; }) => {
          this.invalidLogin = true
          this.error = "Invalid username or password or your account is not active";

        })
    }
  }


  findStuffById()
  {
    this.idLoginUser = Number(sessionStorage.getItem('id'));
    
    this.stuffService.getStuffById(this.idLoginUser)
    .subscribe(res => this.stuff = res);
  }

  findUserById()
  {
    this.idLoginUser = Number(sessionStorage.getItem('id'));
    this.stuffService.getAllUserById(this.idLoginUser)
    .subscribe(res => this.newUser = res);
  }

}