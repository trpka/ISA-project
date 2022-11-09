import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileCenterComponent } from './profile-center.component';

describe('ProfileCenterComponent', () => {
  let component: ProfileCenterComponent;
  let fixture: ComponentFixture<ProfileCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileCenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfileCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
