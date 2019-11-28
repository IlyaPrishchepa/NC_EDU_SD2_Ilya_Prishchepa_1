import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHomePageFormComponent } from './admin-home-page-form.component';

describe('AdminHomePageFormComponent', () => {
  let component: AdminHomePageFormComponent;
  let fixture: ComponentFixture<AdminHomePageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHomePageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHomePageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
