import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationStuffComponent } from './registration-stuff.component';

describe('RegistrationStuffComponent', () => {
  let component: RegistrationStuffComponent;
  let fixture: ComponentFixture<RegistrationStuffComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationStuffComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrationStuffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
