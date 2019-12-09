import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddServicePageFormComponent } from './add-service-page-form.component';

describe('AddServicePageFormComponent', () => {
  let component: AddServicePageFormComponent;
  let fixture: ComponentFixture<AddServicePageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddServicePageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddServicePageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
