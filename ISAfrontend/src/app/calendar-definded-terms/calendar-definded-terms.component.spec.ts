import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarDefindedTermsComponent } from './calendar-definded-terms.component';

describe('CalendarDefindedTermsComponent', () => {
  let component: CalendarDefindedTermsComponent;
  let fixture: ComponentFixture<CalendarDefindedTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalendarDefindedTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalendarDefindedTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
