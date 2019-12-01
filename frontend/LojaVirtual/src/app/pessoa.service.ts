import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { pessoa } from './pessoa.model';

const url = 'http://localhost:8080/pessoa';
const httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({providedIn: 'root'})
export class PessoaService {

	constructor(private http: HttpClient) {}

	consultar(): Observable<pessoa[]> {
		return this.http.get<pessoa[]>(url);
	}

	consultarPorId(id: number): Observable<pessoa> {
		const urlLocal = `${url}/${id}`;
		return this.http.get<pessoa>(urlLocal);
	}

	adicionar(pessoa): Observable<pessoa> {
		return this.http.post<pessoa>(url, pessoa, httpOptions);
	}

	alterar(id, pessoa): Observable<any> {
		const urlLocal = `${url}/${id}`;
		return this.http.put(urlLocal, pessoa, httpOptions);
	}

	excluir(id): Observable<pessoa> {
		const urlLocal = `${url}/${id}`;
		return this.http.delete<pessoa>(urlLocal, httpOptions);
	}
}
