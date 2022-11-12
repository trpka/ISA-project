import { TestBed } from '@angular/core/testing';

import { RegisteredUserEditService } from './registered-user-edit.service';

describe('RegisteredUserEditService', () => {
  let service: RegisteredUserEditService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisteredUserEditService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
