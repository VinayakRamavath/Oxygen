import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SideResComponent } from './sideres.component';

describe('SidebarComponent', () => {
  let component: SideResComponent;
  let fixture: ComponentFixture<SideResComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SideResComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SideResComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
