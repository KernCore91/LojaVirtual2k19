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
	private Pessoa cliente;
	@ManyToOne
	@JoinColumn(name="formapgto_id")
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data_Autorizacao == null) ? 0 : data_Autorizacao.hashCode());
		result = prime * result + ((data_Emissao == null) ? 0 : data_Emissao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((forma_Pgto == null) ? 0 : forma_Pgto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data_Autorizacao == null) {
			if (other.data_Autorizacao != null)
				return false;
		} else if (!data_Autorizacao.equals(other.data_Autorizacao))
			return false;
		if (data_Emissao == null) {
			if (other.data_Emissao != null)
				return false;
		} else if (!data_Emissao.equals(other.data_Emissao))
			return false;
		if (Double.doubleToLongBits(desconto) != Double.doubleToLongBits(other.desconto))
			return false;
		if (forma_Pgto == null) {
			if (other.forma_Pgto != null)
				return false;
		} else if (!forma_Pgto.equals(other.forma_Pgto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	//1 para varios
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItensPedido> listaItensPedido = new ArrayList<ItensPedido>();

	public List<ItensPedido> getListaItensPedido() {return listaItensPedido;}
	public void setListaItensPedido(List<ItensPedido> listaItensPedido) {this.listaItensPedido = listaItensPedido;}
	
}
