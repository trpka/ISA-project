import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpCanReservateTermComponent } from './pop-up-can-reservate-term.component';

describe('PopUpCanReservateTermComponent', () => {
  let component: PopUpCanReservateTermComponent;
  let fixture: ComponentFixture<PopUpCanReservateTermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpCanReservateTermComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpCanReservateTermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
