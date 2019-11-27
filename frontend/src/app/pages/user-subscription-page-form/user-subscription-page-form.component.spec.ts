import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSubscriptionPageFormComponent } from './user-subscription-page-form.component';

describe('UserSubscriptionPageFormComponent', () => {
  let component: UserSubscriptionPageFormComponent;
  let fixture: ComponentFixture<UserSubscriptionPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserSubscriptionPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSubscriptionPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
