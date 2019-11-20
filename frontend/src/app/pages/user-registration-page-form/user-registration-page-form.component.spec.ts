import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegistrationPageFormComponent } from './user-registration-page-form.component';

describe('UserRegistrationPageFormComponent', () => {
  let component: UserRegistrationPageFormComponent;
  let fixture: ComponentFixture<UserRegistrationPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRegistrationPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRegistrationPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
