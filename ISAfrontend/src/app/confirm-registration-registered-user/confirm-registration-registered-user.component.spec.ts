import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmRegistrationRegisteredUserComponent } from './confirm-registration-registered-user.component';

describe('ConfirmRegistrationRegisteredUserComponent', () => {
  let component: ConfirmRegistrationRegisteredUserComponent;
  let fixture: ComponentFixture<ConfirmRegistrationRegisteredUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmRegistrationRegisteredUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmRegistrationRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
