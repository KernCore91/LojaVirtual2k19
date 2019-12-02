import { TestBed } from '@angular/core/testing';

import { FormapgtoService } from './formapgto.service';

describe('FormapgtoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FormapgtoService = TestBed.get(FormapgtoService);
    expect(service).toBeTruthy();
  });
});
