import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHomeFormComponent } from './admin-home-form.component';

describe('AdminHomeFormComponent', () => {
  let component: AdminHomeFormComponent;
  let fixture: ComponentFixture<AdminHomeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHomeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHomeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
