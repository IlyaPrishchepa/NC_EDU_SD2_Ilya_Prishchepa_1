import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyRegistrationPageFormComponent } from './company-registration-page-form.component';

describe('CompanyRegistrationPageFormComponent', () => {
  let component: CompanyRegistrationPageFormComponent;
  let fixture: ComponentFixture<CompanyRegistrationPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyRegistrationPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyRegistrationPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
