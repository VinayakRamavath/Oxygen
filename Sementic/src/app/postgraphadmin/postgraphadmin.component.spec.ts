import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostgraphadminComponent } from './postgraphadmin.component';

describe('PostgraphadminComponent', () => {
  let component: PostgraphadminComponent;
  let fixture: ComponentFixture<PostgraphadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostgraphadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostgraphadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
