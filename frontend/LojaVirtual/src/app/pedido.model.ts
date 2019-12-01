import { pessoa } from './pessoa.model';
import { Formapgto } from './formapgto.model';

export class pedido {
	pedido_id: number;
	pessoa_id: pessoa;
	formapgto_id: Formapgto;
	pedido_data_Emissao: Date;
	pedido_status: String;
	pedido_data_Autorizacao: Date;
	pedido_total: number;
	pedido_desconto: number;
}
