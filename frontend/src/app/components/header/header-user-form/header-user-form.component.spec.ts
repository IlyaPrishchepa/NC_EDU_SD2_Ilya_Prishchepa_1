import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderUserFormComponent } from './header-user-form.component';

describe('HeaderUserFormComponent', () => {
  let component: HeaderUserFormComponent;
  let fixture: ComponentFixture<HeaderUserFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderUserFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderUserFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
