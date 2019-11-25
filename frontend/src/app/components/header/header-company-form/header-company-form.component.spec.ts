import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCompanyFormComponent } from './header-company-form.component';

describe('HeaderCompanyFormComponent', () => {
  let component: HeaderCompanyFormComponent;
  let fixture: ComponentFixture<HeaderCompanyFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderCompanyFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderCompanyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
