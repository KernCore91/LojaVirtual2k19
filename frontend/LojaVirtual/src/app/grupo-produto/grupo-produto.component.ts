import { Component, OnInit } from '@angular/core';
import { grupoproduto } from '../grupo-produto.model';
import { GrupoProdutoService } from '../grupo-produto.service';

@Component({selector: 'app-grupo-produto', templateUrl: './grupo-produto.component.html', styleUrls: ['./grupo-produto.component.css']})
export class GrupoProdutoComponent implements OnInit {

	objeto: grupoproduto = {
		grupoproduto_id: 0,
		grupoproduto_nome: ""
	}
	lista: grupoproduto[] = [];
	mens = '';

	constructor(private service: GrupoProdutoService) {}

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(grupoproduto => {
			this.mens = "Grupo de Produtos " + grupoproduto.grupoproduto_nome + " adicionado com sucesso";
			this.consultar();
		});
	}

	excluir() {
		this.service.excluir(this.objeto.grupoproduto_id).toPromise().then(grupoproduto => {
			this.mens = "Grupo de Produtos excluído com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.grupoproduto_id, this.objeto).toPromise().then(grupoproduto => {
			this.mens = "Grupo de Produtos " + grupoproduto.grupoproduto_nome + " alterado com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: grupoproduto) {
		this.objeto = f;
	}
}
