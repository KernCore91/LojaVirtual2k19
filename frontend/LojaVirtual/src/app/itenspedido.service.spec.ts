import { TestBed } from '@angular/core/testing';

import { ItenspedidoService } from './itenspedido.service';

describe('ItenspedidoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ItenspedidoService = TestBed.get(ItenspedidoService);
    expect(service).toBeTruthy();
  });
});
