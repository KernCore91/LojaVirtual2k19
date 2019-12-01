import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { Message } from 'primeng/components/common/api'
import { MessageModule } from 'primeng/message'
import { MessagesModule } from 'primeng/messages'
import { ButtonModule } from 'primeng/button'
import { CalendarModule } from 'primeng/calendar'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PessoaComponent } from './pessoa/pessoa.component';
import { PessoaService } from './pessoa.service';
import { ProdutoComponent } from './produto/produto.component';
import { ProdutoService } from './produto.service';
import { GrupoProdutoComponent } from './grupo-produto/grupo-produto.component';
import { GrupoProdutoService } from './grupo-produto.service';
import { FormapgtoComponent } from './formapgto/formapgto.component';
import { FormapgtoService } from './formapgto.service';
import { PedidoComponent } from './pedido/pedido.component';
import { PedidoService } from './pedido.service';
import { ItenspedidoComponent } from './itenspedido/itenspedido.component';
import { ItenspedidoService } from './itenspedido.service';

@NgModule({
  declarations: [
    AppComponent,
    PessoaComponent,
    ProdutoComponent,
    GrupoProdutoComponent,
    FormapgtoComponent,
    PedidoComponent,
    ItenspedidoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CalendarModule,
    ButtonModule,
    MessageModule,
    MessagesModule,
    AppRoutingModule
  ],
  providers: [PessoaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
