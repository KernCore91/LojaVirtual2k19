import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Formapgto } from './formapgto.model';

const url = 'http://localhost:8080/formapgto';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class FormapgtoService {

	constructor(private http: HttpClient) {}

	consultar(): Observable<Formapgto[]> {
		return this.http.get<Formapgto[]>(url);
	}

	consultarPorId(id: number): Observable<Formapgto> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<Formapgto>(urlLocal);
	}

	adicionar(Formapgto): Observable<Formapgto> {
		return this.http.post<Formapgto>(url, Formapgto, httpOptions);
	}

	alterar(id, Formapgto): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, Formapgto, httpOptions);
	}

	excluir(id): Observable<Formapgto> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<Formapgto>(urlLocal, httpOptions);
	}
}
