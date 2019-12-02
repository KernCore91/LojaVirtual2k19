import { Component, OnInit } from '@angular/core';
import { pedido } from '../pedido.model';
import { PedidoService } from '../pedido.service';
import { Formapgto } from '../formapgto.model';
import { FormapgtoService } from '../formapgto.service';
import { pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({selector: 'app-pedido', templateUrl: './pedido.component.html', styleUrls: ['./pedido.component.css']})
export class PedidoComponent implements OnInit {

	constructor(private service: PedidoService, private FService: FormapgtoService, private PService: PessoaService) {}

	objeto: pedido = {
		pedido_id: 0,
		pessoa_id: new pessoa,
		formapgto_id: new Formapgto,
		pedido_data_Emissao: new Date(),
		pedido_status: '',
		pedido_data_Autorizacao: new Date(),
		pedido_total: 0,
		pedido_desconto: 0
	};
	pessoaSelectId: number = 0;
	formapgtoSelectId: number = 0;
	lista: pedido[] = [];
	listaPessoa: pessoa[] = [];
	listaFormapgto: Formapgto[] = [];
	mens = '';

	ngOnInit() {
		this.consultar();
	}

	consultar() {
		this.service.consultar().toPromise().then(p => { this.lista = p; });
		this.FService.consultar().toPromise().then(p => { this.listaFormapgto = p; });
		this.PService.consultar().toPromise().then(p => { this.listaPessoa = p; });
	}

	adicionar() {
		this.service.adicionar(this.objeto).toPromise().then(pedido => {
			this.mens = "Pedido " + pedido.pedido_status + " feito com sucesso";
			this.consultar();
		});

		this.listaPessoa.forEach(element => {
			if(element.pessoa_id == this.pessoaSelectId){
				this.objeto.pessoa_id.pessoa_id = element.pessoa_id;
			}
		});

		this.listaFormapgto.forEach(element => {
			if(element.formapgto_id == this.formapgtoSelectId){
				this.objeto.formapgto_id.formapgto_id = element.formapgto_id;
			}
		});
	}

	excluir() {
		this.service.excluir(this.objeto.pedido_id).toPromise().then(pedido => {
			this.mens = "Pedido removido com sucesso";
			this.consultar();
		});
	}

	alterar() {
		this.service.alterar(this.objeto.pedido_id, this.objeto).toPromise().then(pedido => {
			this.mens = "Pedido " + pedido.pedido_status + " atualizado com sucesso";
			this.consultar();
		});
	}

	carregarDados(f: pedido) {
		this.objeto = f;
	}
}