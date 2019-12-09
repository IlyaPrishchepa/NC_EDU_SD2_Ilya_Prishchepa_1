import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyHomeFormComponent } from './company-home-form.component';

describe('CompanyHomeFormComponent', () => {
  let component: CompanyHomeFormComponent;
  let fixture: ComponentFixture<CompanyHomeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyHomeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyHomeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
