
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { StuffService } from '../service/stuff.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  id: any;
  newPassword: any;
  passwordConfirm: any;
  firstStuffLogin: boolean = false;
  formV: FormGroup;

  constructor(private stuffService: StuffService, private route: ActivatedRoute
    ,private router: Router, private fb: FormBuilder) { }

    ngOnInit(): void 
    {
      this.formV = this.fb.group
      ({
  
        newPassword: ['', Validators.required],
        passwordConfirm: ['', Validators.required]
  
      });
    }
    get registerFormControl() 
    {
      return this.formV.controls;
    }

    submitPassword() {
      this.id = sessionStorage.getItem('id');
      if (this.formV.valid) 
      {
  
        if ((this.newPassword != this.passwordConfirm))
          alert("New and confirmed password don't match!");
        else
          this.stuffService.changePassword(this.id, this.newPassword).
            subscribe(res => {
              alert("password successfully changed!")
              this.goToProfilePage();
            })
  
      }
      else
        alert("Fill the required fields!");
  
    }
  

  goToProfilePage()
  {
    this.firstStuffLogin = false;
    this.router.navigate(['/stuff_edit/' + this.id]);

  }



}
