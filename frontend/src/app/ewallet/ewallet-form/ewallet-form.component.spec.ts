import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwalletFormComponent } from './ewallet-form.component';

describe('EwalletFormComponent', () => {
  let component: EwalletFormComponent;
  let fixture: ComponentFixture<EwalletFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwalletFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwalletFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
