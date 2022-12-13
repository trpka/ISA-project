import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDonationTermComponent } from './create-donation-term.component';

describe('CreateDonationTermComponent', () => {
  let component: CreateDonationTermComponent;
  let fixture: ComponentFixture<CreateDonationTermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDonationTermComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateDonationTermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
