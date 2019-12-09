import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwalletCompanyPageFormComponent } from './ewallet-company-page-form.component';

describe('EwalletCompanyPageFormComponent', () => {
  let component: EwalletCompanyPageFormComponent;
  let fixture: ComponentFixture<EwalletCompanyPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwalletCompanyPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwalletCompanyPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
