import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionFilmsComponent } from './gestion-films.component';

describe('GestionFilmsComponent', () => {
  let component: GestionFilmsComponent;
  let fixture: ComponentFixture<GestionFilmsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GestionFilmsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GestionFilmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
