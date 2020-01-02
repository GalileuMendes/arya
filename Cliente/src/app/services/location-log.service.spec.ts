import { TestBed } from '@angular/core/testing';

import { LocationLogService } from './location-log.service';

describe('LocationLogService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LocationLogService = TestBed.get(LocationLogService);
    expect(service).toBeTruthy();
  });
});
