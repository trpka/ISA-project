import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProfileCenterComponent } from './new-profile-center.component';

describe('NewProfileCenterComponent', () => {
  let component: NewProfileCenterComponent;
  let fixture: ComponentFixture<NewProfileCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewProfileCenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewProfileCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
