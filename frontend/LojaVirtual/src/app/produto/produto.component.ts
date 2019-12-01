import { Component, OnInit } from '@angular/core';
import { produto } from '../produto.model';
import { ProdutoService } from '../produto.service';
import { grupoproduto } from '../grupo-produto.model';
import { GrupoProdutoService } from '../grupo-produto.service';

@Component({ selector: 'app-produto', templateUrl: './produto.component.html', styleUrls: ['./produto.component.css']})
export class ProdutoComponent implements OnInit {

	objeto: produto = {
		produto_id: 0,
		produto_nome: "",
		produto_preco: 0,
		produto_descricao: "",
		produto_qtde_Estoque: 0,
		produto_und: "",
		grupoproduto_id: new grupoproduto
	};
	grupoSelectId: number = 0;
	lista: produto[] = [];
	listaGrupos: grupoproduto[] = [];
	mens = '';

	constructor(private service: ProdutoService, private GService: GrupoProdutoService) {}

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
		this.GService.consultar().toPromise().then(p => { this.listaGrupos = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(produto => {
			this.mens = "Produto " + produto.produto_nome + " adicionado com sucesso";
			this.consultar();
		});

		this.listaGrupos.forEach(element => {
			if(element.grupoproduto_id == this.grupoSelectId){
				this.objeto.grupoproduto_id.grupoproduto_id = element.grupoproduto_id;
				this.objeto.produto_nome = element.grupoproduto_nome;
			}
		});
	}

	excluir() {
		this.service.excluir(this.objeto.produto_id).toPromise().then(produto => {
			this.mens = "Produto excluído com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.produto_id, this.objeto).toPromise().then(produto => {
			this.mens = "Produto " + produto.produto_nome + " alterado com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: produto) {
		this.objeto = f;
	}
}