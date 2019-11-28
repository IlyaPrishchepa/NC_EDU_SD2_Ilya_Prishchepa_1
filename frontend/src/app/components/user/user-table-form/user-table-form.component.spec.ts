import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTableFormComponent } from './user-table-form.component';

describe('UserTableFormComponent', () => {
  let component: UserTableFormComponent;
  let fixture: ComponentFixture<UserTableFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTableFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTableFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
