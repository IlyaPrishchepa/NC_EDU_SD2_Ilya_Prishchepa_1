import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderAdminFormComponent } from './header-admin-form.component';

describe('HeaderAdminFormComponent', () => {
  let component: HeaderAdminFormComponent;
  let fixture: ComponentFixture<HeaderAdminFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderAdminFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderAdminFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
