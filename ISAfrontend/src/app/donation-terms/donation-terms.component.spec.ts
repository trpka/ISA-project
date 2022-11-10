import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonationTermsComponent } from './donation-terms.component';

describe('DonationTermsComponent', () => {
  let component: DonationTermsComponent;
  let fixture: ComponentFixture<DonationTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonationTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonationTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
