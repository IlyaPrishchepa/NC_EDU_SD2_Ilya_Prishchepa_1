import { TestBed } from '@angular/core/testing';

import { EwalletService } from './ewallet.service';

describe('EwalletService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EwalletService = TestBed.get(EwalletService);
    expect(service).toBeTruthy();
  });
});
