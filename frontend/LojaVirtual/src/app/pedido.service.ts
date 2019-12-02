import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { pedido } from './pedido.model';

const url = 'http://localhost:8080/pedido';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class PedidoService {

  constructor(private http: HttpClient) {}

	consultar(): Observable<pedido[]> {
		return this.http.get<pedido[]>(url);
	}

	consultarPorId(id: number): Observable<pedido> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<pedido>(urlLocal);
	}

	adicionar(pedido): Observable<pedido> {
		return this.http.post<pedido>(url, pedido, httpOptions);
	}

	alterar(id, pedido): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, pedido, httpOptions);
	}

	excluir(id): Observable<pedido> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<pedido>(urlLocal, httpOptions);
	}
}