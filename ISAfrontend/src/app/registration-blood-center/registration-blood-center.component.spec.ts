import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationBloodCenterComponent } from './registration-blood-center.component';

describe('RegistrationBloodCenterComponent', () => {
  let component: RegistrationBloodCenterComponent;
  let fixture: ComponentFixture<RegistrationBloodCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationBloodCenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrationBloodCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
