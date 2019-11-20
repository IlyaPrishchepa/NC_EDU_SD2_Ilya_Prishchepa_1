import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyHomePageFormComponent } from './company-home-page-form.component';

describe('CompanyHomePageFormComponent', () => {
  let component: CompanyHomePageFormComponent;
  let fixture: ComponentFixture<CompanyHomePageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyHomePageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyHomePageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
