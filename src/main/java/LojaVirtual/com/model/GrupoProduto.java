package LojaVirtual.com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupoproduto")
public class GrupoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grupoproduto_id")
	private Long id;
	@Column(name = "grupoproduto_nome")
	private String nome;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		GrupoProduto other = (GrupoProduto) obj;
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
		return true;
	}

	//1 pra varios
	@OneToMany(mappedBy = "grupoProduto", cascade = CascadeType.ALL)
	private List<Produto> listaProdutos = new ArrayList<Produto>();

	public List<Produto> getListaProdutos() {return listaProdutos;}
	public void setListaProdutos(List<Produto> listaProdutos) {this.listaProdutos = listaProdutos;}
}
