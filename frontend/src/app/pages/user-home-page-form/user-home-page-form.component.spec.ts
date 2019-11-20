import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomePageFormComponent } from './user-home-page-form.component';

describe('UserHomePageFormComponent', () => {
  let component: UserHomePageFormComponent;
  let fixture: ComponentFixture<UserHomePageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHomePageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHomePageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
