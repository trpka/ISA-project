import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpCancelReservationComponent } from './pop-up-cancel-reservation.component';

describe('PopUpCancelReservationComponent', () => {
  let component: PopUpCancelReservationComponent;
  let fixture: ComponentFixture<PopUpCancelReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpCancelReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpCancelReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
