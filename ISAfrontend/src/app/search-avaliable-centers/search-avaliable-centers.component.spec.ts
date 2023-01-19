import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAvaliableCentersComponent } from './search-avaliable-centers.component';

describe('SearchAvaliableCentersComponent', () => {
  let component: SearchAvaliableCentersComponent;
  let fixture: ComponentFixture<SearchAvaliableCentersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAvaliableCentersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchAvaliableCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
