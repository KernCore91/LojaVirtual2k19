package LojaVirtual.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itenspedido")
public class ItensPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itenspedido_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	@Column(name = "itenspedido_qtde")
	private double qtde;
	@Column(name = "itenspedido_valor_Unit")
	private double valor_Unit;
	@Column(name = "itenspedido_sub_Total")
	private double sub_Total;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public Pedido getPedido() {return pedido;}
	public void setPedido(Pedido pedido) {this.pedido = pedido;}
	
	public Produto getProduto() {return produto;}
	public void setProduto(Produto produto) {this.produto = produto;}
	
	public double getQtde() {return qtde;}
	public void setQtde(double qtde) {this.qtde = qtde;}
	
	public double getValor_Unit() {return valor_Unit;}
	public void setValor_Unit(double valor_Unit) {this.valor_Unit = valor_Unit;}
	
	public double getSub_Total() {return sub_Total;}
	public void setSub_Total(double sub_Total) {this.sub_Total = sub_Total;}
}
