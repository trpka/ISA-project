import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pop-up-cancel-reservation',
  templateUrl: './pop-up-cancel-reservation.component.html',
  styleUrls: ['./pop-up-cancel-reservation.component.css']
})
export class PopUpCancelReservationComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }


}
