import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryPageFormComponent } from './category-page-form.component';

describe('CategoryPageFormComponent', () => {
  let component: CategoryPageFormComponent;
  let fixture: ComponentFixture<CategoryPageFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryPageFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryPageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
