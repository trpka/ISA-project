import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRegisteredUsersComponent } from './all-registered-users.component';

describe('AllRegisteredUsersComponent', () => {
  let component: AllRegisteredUsersComponent;
  let fixture: ComponentFixture<AllRegisteredUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllRegisteredUsersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllRegisteredUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
