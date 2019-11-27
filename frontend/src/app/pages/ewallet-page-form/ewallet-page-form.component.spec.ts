import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EwalletPageFormComponent } from './ewallet-page-form.component';

describe('EwalletPageFormComponent', () => {
  let component: EwalletPageFormComponent;
  let fixture: ComponentFixture<EwalletPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EwalletPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EwalletPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
