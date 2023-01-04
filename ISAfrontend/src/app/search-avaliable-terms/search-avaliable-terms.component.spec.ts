import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAvaliableTermsComponent } from './search-avaliable-terms.component';

describe('SearchAvaliableTermsComponent', () => {
  let component: SearchAvaliableTermsComponent;
  let fixture: ComponentFixture<SearchAvaliableTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAvaliableTermsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchAvaliableTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
