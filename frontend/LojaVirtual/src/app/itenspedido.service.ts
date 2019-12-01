import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { itenspedido } from './itenspedido.model';

const url = 'http://localhost:8080/itenspedido';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class ItenspedidoService {

  constructor(private http: HttpClient) {}

	consultar(): Observable<itenspedido[]> {
		return this.http.get<itenspedido[]>(url);
	}

	consultarPorId(id: number): Observable<itenspedido> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<itenspedido>(urlLocal);
	}

	adicionar(itenspedido): Observable<itenspedido> {
		return this.http.post<itenspedido>(url, itenspedido, httpOptions);
	}

	alterar(id, itenspedido): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, itenspedido, httpOptions);
	}

	excluir(id): Observable<itenspedido> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<itenspedido>(urlLocal, httpOptions);
	}
}