import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpDisableCancelReservationComponent } from './pop-up-disable-cancel-reservation.component';

describe('PopUpDisableCancelReservationComponent', () => {
  let component: PopUpDisableCancelReservationComponent;
  let fixture: ComponentFixture<PopUpDisableCancelReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpDisableCancelReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpDisableCancelReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
