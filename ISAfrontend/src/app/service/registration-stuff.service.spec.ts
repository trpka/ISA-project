import { TestBed } from '@angular/core/testing';

import { RegistrationStuffService } from './registration-stuff.service';

describe('RegistrationStuffService', () => {
  let service: RegistrationStuffService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrationStuffService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
