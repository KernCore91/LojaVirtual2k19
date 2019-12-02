import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { produto } from './produto.model';

const url = 'http://localhost:8080/produto';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class ProdutoService {

	constructor(private http: HttpClient) {}

	consultar(): Observable<produto[]> {
		return this.http.get<produto[]>(url);
	}

	consultarPorId(id: number): Observable<produto> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<produto>(urlLocal);
	}

	adicionar(produto): Observable<produto> {
		return this.http.post<produto>(url, produto, httpOptions);
	}

	alterar(id, produto): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, produto, httpOptions);
	}

	excluir(id): Observable<produto> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<produto>(urlLocal, httpOptions);
	}
}
