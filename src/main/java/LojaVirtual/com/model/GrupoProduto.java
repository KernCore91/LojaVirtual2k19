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
	
	//1 pra varios
	@OneToMany(mappedBy = "grupoProduto", cascade = CascadeType.ALL)
	private List<Produto> listaProdutos = new ArrayList<Produto>();

	public List<Produto> getListaProdutos() {return listaProdutos;}
	public void setListaProdutos(List<Produto> listaProdutos) {this.listaProdutos = listaProdutos;}
}
