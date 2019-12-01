import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItenspedidoComponent } from './itenspedido.component';

describe('ItenspedidoComponent', () => {
  let component: ItenspedidoComponent;
  let fixture: ComponentFixture<ItenspedidoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItenspedidoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItenspedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
