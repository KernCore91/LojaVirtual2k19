import { TestBed } from '@angular/core/testing';

import { GrupoProdutoService } from './grupo-produto.service';

describe('GrupoProdutoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GrupoProdutoService = TestBed.get(GrupoProdutoService);
    expect(service).toBeTruthy();
  });
});
