import { Component, OnInit } from '@angular/core';
import { pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({
  selector: 'app-pessoa',
  templateUrl: './pessoa.component.html',
  styleUrls: ['./pessoa.component.css']
})
export class PessoaComponent implements OnInit {

	objeto: pessoa = {
		pessoa_id: 0,
		pessoa_nome: "",
		pessoa_cpf: "",
		pessoa_rg: "",
		pessoa_data_Nasc: new Date(),
		pessoa_rua: "",
		pessoa_bairro: "",
		pessoa_cidade: "",
		pessoa_uf: "",
		pessoa_cep: 0,
		pessoa_email: "",
		pessoa_senha: "",
		pessoa_tipo: "",
		pessoa_fone1: "",
		pessoa_fone2: ""
	};
	lista: pessoa[] = [];
	mens = '';

	constructor(private service: PessoaService) {}

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(pessoa => {
			this.mens = "Pessoa " + pessoa.pessoa_nome + " adicionada com sucesso";
			this.consultar();
		});
	}

	excluir() {
		this.service.excluir(this.objeto.pessoa_id).toPromise().then(pessoa => {
			this.mens = "Pessoa excluída com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.pessoa_id, this.objeto).toPromise().then(pessoa => {
			this.mens = "Pessoa " + pessoa.pessoa_nome + " alterada com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: pessoa) {
		this.objeto = f;
	}
}
