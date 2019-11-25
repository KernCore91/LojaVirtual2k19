package LojaVirtual.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	//@Column(name = "pedido_cliente")
	private Pessoa cliente;
	@ManyToOne
	@JoinColumn(name="formapgto_id")
	//@Column(name = "pedido_forma_Pgto")
	private FormaPgto forma_Pgto;
	@Column(name = "pedido_data_Emissao")
	private Date data_Emissao;
	@Column(name = "pedido_status")
	private String status;
	@Column(name = "pedido_data_Autorizacao")
	private Date data_Autorizacao;
	@Column(name = "pedido_total")
	private double total;
	@Column(name = "pedido_desconto")
	private double desconto;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public Pessoa getCliente() {return cliente;}
	public void setCliente(Pessoa cliente) {this.cliente = cliente;}
	
	public FormaPgto getForma_Pgto() {return forma_Pgto;}
	public void setForma_Pgto(FormaPgto forma_Pgto) {this.forma_Pgto = forma_Pgto;}
	
	public Date getData_Emissao() {return data_Emissao;}
	public void setData_Emissao(Date data_Emissao) {this.data_Emissao = data_Emissao;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	public Date getData_Autorizacao() {return data_Autorizacao;}
	public void setData_Autorizacao(Date data_Autorizacao) {this.data_Autorizacao = data_Autorizacao;}
	
	public double getTotal() {return total;}
	public void setTotal(double total) {this.total = total;}
	
	public double getDesconto() {return desconto;}
	public void setDesconto(double desconto) {this.desconto = desconto;}
	
	//1 para varios
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItensPedido> listaItensPedido = new ArrayList<ItensPedido>();

	public List<ItensPedido> getListaItensPedido() {return listaItensPedido;}
	public void setListaItensPedido(List<ItensPedido> listaItensPedido) {this.listaItensPedido = listaItensPedido;}
	
}
