import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredUserEditComponent } from './registered-user-edit.component';

describe('RegisteredUserEditComponent', () => {
  let component: RegisteredUserEditComponent;
  let fixture: ComponentFixture<RegisteredUserEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredUserEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisteredUserEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
