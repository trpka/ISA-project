import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpCannotReservateTermComponent } from './pop-up-cannot-reservate-term.component';

describe('PopUpCannotReservateTermComponent', () => {
  let component: PopUpCannotReservateTermComponent;
  let fixture: ComponentFixture<PopUpCannotReservateTermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopUpCannotReservateTermComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopUpCannotReservateTermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
