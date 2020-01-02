import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocationLogComponent } from './location-log.component';

describe('LocationLogComponent', () => {
  let component: LocationLogComponent;
  let fixture: ComponentFixture<LocationLogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocationLogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocationLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
