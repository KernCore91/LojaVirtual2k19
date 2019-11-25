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
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Long id;
	@Column(name = "produto_nome")
	private String nome;
	@Column(name = "produto_preco")
	private double preco;
	@Column(name = "produto_descricao")
	private String descricao;
	@Column(name = "produto_qtde_Estoque")
	private double qtde_Estoque;
	@Column(name = "produto_und")
	private String und;
	@ManyToOne
	@JoinColumn(name="grupoproduto_id")
	private GrupoProduto grupoProduto;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public double getPreco() {return preco;}
	public void setPreco(double preco) {this.preco = preco;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public double getQtde_Estoque() {return qtde_Estoque;}
	public void setQtde_Estoque(double qtde_Estoque) {this.qtde_Estoque = qtde_Estoque;}
	
	public String getUnd() {return und;}
	public void setUnd(String und) {this.und = und;}
	
	public GrupoProduto getGrupoProduto() {return grupoProduto;}
	public void setGrupoProduto(GrupoProduto grupoProduto) {this.grupoProduto = grupoProduto;}
}
