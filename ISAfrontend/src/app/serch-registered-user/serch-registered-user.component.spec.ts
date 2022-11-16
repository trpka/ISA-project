import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SerchRegisteredUserComponent } from './serch-registered-user.component';

describe('SerchRegisteredUserComponent', () => {
  let component: SerchRegisteredUserComponent;
  let fixture: ComponentFixture<SerchRegisteredUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SerchRegisteredUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SerchRegisteredUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
