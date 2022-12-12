import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StuffUserProfileComponent } from './stuff-user-profile.component';

describe('StuffUserProfileComponent', () => {
  let component: StuffUserProfileComponent;
  let fixture: ComponentFixture<StuffUserProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StuffUserProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StuffUserProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
