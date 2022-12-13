import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisteredUserEditService } from '../service/registered-user-edit.service';

@Component({
  selector: 'app-confirm-registration-registered-user',
  templateUrl: './confirm-registration-registered-user.component.html',
  styleUrls: ['./confirm-registration-registered-user.component.css']
})
export class ConfirmRegistrationRegisteredUserComponent implements OnInit {
  id:number;
  constructor(private route: ActivatedRoute,private router: Router,private registeredUserEditService: RegisteredUserEditService) { }

  ngOnInit(): void {
  }

  activateAccount(){
    this.id = this.route.snapshot.params['id'];
    this.registeredUserEditService.activateById(this.id)
    .subscribe();
    this.router.navigate(['login']);
  }

}
