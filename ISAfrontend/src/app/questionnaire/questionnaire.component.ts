import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.css']
})
export class QuestionnaireComponent implements OnInit {
  id:number;
  numberOfDonator: string;
  date: string;
  firstName: string;
  lastName: string;
  jmbg: string;
  dateOfBirth:string;
  sex:string;
  adress:string;
  township: string ;
  city:string;
  mobile:string;
  company:string;
  profession: string;
  numberOfBoodDonations: string;
  p1:string;
  p2:string;
  p3:string;
  //answers: [];
  constructor() { }

  ngOnInit(): void {
  }

  save(){
     
    //console.log(this.newUser)
   // this.registrationService.registration(this.newUser)
   // .subscribe(_=>this.reloadData());
  }
}
