import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StuffSurveyComponent } from './stuff-survey.component';

describe('StuffSurveyComponent', () => {
  let component: StuffSurveyComponent;
  let fixture: ComponentFixture<StuffSurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StuffSurveyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StuffSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
