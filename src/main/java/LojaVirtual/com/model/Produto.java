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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((grupoProduto == null) ? 0 : grupoProduto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(qtde_Estoque);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((und == null) ? 0 : und.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (grupoProduto == null) {
			if (other.grupoProduto != null)
				return false;
		} else if (!grupoProduto.equals(other.grupoProduto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (Double.doubleToLongBits(qtde_Estoque) != Double.doubleToLongBits(other.qtde_Estoque))
			return false;
		if (und == null) {
			if (other.und != null)
				return false;
		} else if (!und.equals(other.und))
			return false;
		return true;
	}
}
