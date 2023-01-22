import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FutureTermsComponent } from './future-terms.component';

describe('FutureTermsComponent', () => {
  let component: FutureTermsComponent;
  let fixture: ComponentFixture<FutureTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FutureTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FutureTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
