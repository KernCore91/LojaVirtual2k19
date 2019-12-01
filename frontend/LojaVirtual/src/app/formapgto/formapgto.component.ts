import { Component, OnInit } from '@angular/core';
import { Formapgto } from '../formapgto.model';
import { FormapgtoService } from '../formapgto.service';

@Component({selector: 'app-formapgto', templateUrl: './formapgto.component.html', styleUrls: ['./formapgto.component.css']})
export class FormapgtoComponent implements OnInit {

	objeto: Formapgto = {
		formapgto_id: 0,
		formapgto_descricao: "",
		formapgto_num_Max_Parc: 0,
		formapgto_Padrao_Parc: 0,
		formapgto_intervalo_Dias: 0,
		formapgto_percentual_Acres: 0
	};
	lista: Formapgto[] = [];
	mens = '';

	constructor(private service: FormapgtoService) {}

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(Formapgto => {
			this.mens = "Forma de pagamento: " + Formapgto.formapgto_descricao + " adicionado com sucesso";
			this.consultar();
		});
	}

	excluir() {
		this.service.excluir(this.objeto.formapgto_id).toPromise().then(Formapgto => {
			this.mens = "Forma de pagamento excluído com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.formapgto_id, this.objeto).toPromise().then(Formapgto => {
			this.mens = "Forma de pagamento: " + Formapgto.formapgto_descricao + " alterado com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: Formapgto) {
		this.objeto = f;
	}
}