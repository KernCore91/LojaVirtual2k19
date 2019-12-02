import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoaComponent } from './pessoa/pessoa.component';
import { GrupoProdutoComponent } from './grupo-produto/grupo-produto.component';
import { ProdutoComponent } from './produto/produto.component';
import { FormapgtoComponent } from './formapgto/formapgto.component';
import { PedidoComponent } from './pedido/pedido.component';
import { ItenspedidoComponent } from './itenspedido/itenspedido.component';


const routes: Routes = [
  { path: '', component: Component },
  { path: 'grupo-produto', component: GrupoProdutoComponent },
  { path: 'produto', component: ProdutoComponent },
  { path: 'pessoa', component: PessoaComponent },
  { path: 'formapgto', component: FormapgtoComponent },
  { path: 'pedido', component: PedidoComponent },
  { path: 'itenspedido', component: ItenspedidoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
