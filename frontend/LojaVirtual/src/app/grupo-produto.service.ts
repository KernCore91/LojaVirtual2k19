import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { grupoproduto } from './grupo-produto.model';

const url = 'http://localhost:8080/grupoproduto';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class GrupoProdutoService {

	constructor(private http: HttpClient) {}

	consultar(): Observable<grupoproduto[]> {
		return this.http.get<grupoproduto[]>(url);
	}

	consultarPorId(id: number): Observable<grupoproduto> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<grupoproduto>(urlLocal);
	}

	adicionar(grupoproduto): Observable<grupoproduto> {
		return this.http.post<grupoproduto>(url, grupoproduto, httpOptions);
	}

	alterar(id, grupoproduto): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, grupoproduto, httpOptions);
	}

	excluir(id): Observable<grupoproduto> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<grupoproduto>(urlLocal, httpOptions);
	}
}
