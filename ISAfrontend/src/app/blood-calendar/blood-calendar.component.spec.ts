import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodCalendarComponent } from './blood-calendar.component';

describe('BloodCalendarComponent', () => {
  let component: BloodCalendarComponent;
  let fixture: ComponentFixture<BloodCalendarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodCalendarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodCalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
