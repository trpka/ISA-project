import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpSuccessfullyMakeAppointmentComponent } from './pop-up-successfully-make-appointment.component';

describe('PopUpSuccessfullyMakeAppointmentComponent', () => {
  let component: PopUpSuccessfullyMakeAppointmentComponent;
  let fixture: ComponentFixture<PopUpSuccessfullyMakeAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpSuccessfullyMakeAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpSuccessfullyMakeAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
