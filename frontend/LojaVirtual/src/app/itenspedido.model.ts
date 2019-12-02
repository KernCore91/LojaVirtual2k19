import { pedido } from './pedido.model'
import { produto } from './produto.model'

export class itenspedido {
	itenspedido_id: number;
	pedido_id: pedido;
	produto_id: produto;
	itenspedido_qtde: number;
	itenspedido_valor_Unit: number;
	itenspedido_sub_Total: number;
}
