import { TestBed } from '@angular/core/testing';

import { EpcService } from './epc.service';

describe('EpcService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EpcService = TestBed.get(EpcService);
    expect(service).toBeTruthy();
  });
});
