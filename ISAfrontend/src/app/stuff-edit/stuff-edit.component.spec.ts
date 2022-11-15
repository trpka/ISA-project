import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StuffEditComponent } from './stuff-edit.component';

describe('StuffEditComponent', () => {
  let component: StuffEditComponent;
  let fixture: ComponentFixture<StuffEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StuffEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StuffEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
