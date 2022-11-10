import { TestBed } from '@angular/core/testing';

import { DonationTermsService } from './donation-terms.service';

describe('DonationTermsService', () => {
  let service: DonationTermsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DonationTermsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
