import { grupoproduto } from './grupo-produto.model';

export class produto {
	produto_id: number;
	produto_nome: String;
	produto_preco: number;
	produto_descricao: String;
	produto_qtde_Estoque: number;
	produto_und: String;
	grupoproduto_id: grupoproduto;
}
