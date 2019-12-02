import { Component, OnInit } from '@angular/core';
import { pedido } from '../pedido.model';
import { PedidoService } from '../pedido.service';
import { produto } from '../produto.model';
import { ProdutoService } from '../produto.service';
import { itenspedido } from '../itenspedido.model';
import { ItenspedidoService } from '../itenspedido.service';

@Component({selector: 'app-itenspedido', templateUrl: './itenspedido.component.html', styleUrls: ['./itenspedido.component.css']})
export class ItenspedidoComponent implements OnInit {

	constructor(private service: ItenspedidoService, private PService: PedidoService, private GService: ProdutoService) {}

	objeto: itenspedido = {
		itenspedido_id: 0,
		pedido_id: new pedido,
		produto_id: new produto,
		itenspedido_qtde: 0,
		itenspedido_valor_Unit: 0,
		itenspedido_sub_Total: 0
	};
	pedidoSelectId: number = 0;
	produtoSelectId: number = 0;
	lista: itenspedido[] = [];
	listaPedido: pedido[] = [];
	listaProduto: produto[] = [];
	mens = '';

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
		this.PService.consultar().toPromise().then(p => { this.listaPedido = p; });
		this.GService.consultar().toPromise().then(p => { this.listaProduto = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(itenspedido => {
			this.mens = "Quantidade de itens no pedido: " + itenspedido.itenspedido_qtde + " sucesso";
			this.consultar();
		});

		this.listaPedido.forEach(element => {
			if(element.pedido_id == this.pedidoSelectId){
				this.objeto.pedido_id.pedido_id = element.pedido_id;
			}
		});

		this.listaProduto.forEach(element => {
			if(element.produto_id == this.produtoSelectId){
				this.objeto.produto_id.produto_id = element.produto_id;
			}
		});
	}

	excluir() {
		this.service.excluir(this.objeto.itenspedido_id).toPromise().then(itenspedido => {
			this.mens = "Quantidade de itens no pedido removido com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.itenspedido_id, this.objeto).toPromise().then(itenspedido => {
			this.mens = "Quantidade de itens no pedido " + itenspedido.itenspedido_qtde + " atualizado com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: itenspedido) {
		this.objeto = f;
	}
}