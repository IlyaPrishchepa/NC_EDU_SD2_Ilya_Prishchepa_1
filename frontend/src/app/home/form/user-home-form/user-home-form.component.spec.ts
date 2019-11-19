import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeFormComponent } from './user-home-form.component';

describe('UserHomeFormComponent', () => {
  let component: UserHomeFormComponent;
  let fixture: ComponentFixture<UserHomeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHomeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHomeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
