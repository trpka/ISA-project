import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfTermsComponent } from './list-of-terms.component';

describe('ListOfTermsComponent', () => {
  let component: ListOfTermsComponent;
  let fixture: ComponentFixture<ListOfTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListOfTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
