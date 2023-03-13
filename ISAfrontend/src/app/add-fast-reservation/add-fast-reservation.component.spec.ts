import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFastReservationComponent } from './add-fast-reservation.component';

describe('AddFastReservationComponent', () => {
  let component: AddFastReservationComponent;
  let fixture: ComponentFixture<AddFastReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFastReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddFastReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
