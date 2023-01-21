import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryTermsComponent } from './history-terms.component';

describe('HistoryTermsComponent', () => {
  let component: HistoryTermsComponent;
  let fixture: ComponentFixture<HistoryTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoryTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoryTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
