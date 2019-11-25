import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewArtistComponent } from './new-artist.component';

describe('NewArtistComponent', () => {
  let component: NewArtistComponent;
  let fixture: ComponentFixture<NewArtistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewArtistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewArtistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
