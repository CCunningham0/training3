import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestComponentGeneratedComponent } from './test-component-generated.component';

describe('TestComponentGeneratedComponent', () => {
  let component: TestComponentGeneratedComponent;
  let fixture: ComponentFixture<TestComponentGeneratedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestComponentGeneratedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestComponentGeneratedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
