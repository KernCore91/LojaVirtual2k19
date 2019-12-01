package LojaVirtual.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoa_id")
	private Long id;
	@Column(name = "pessoa_nome")
	private String nome;
	@Column(name = "pessoa_cpf")
	private String cpf;
	@Column(name = "pessoa_rg")
	private String rg;
	@Column(name = "pessoa_data_Nasc")
	private Date data_Nasc;
	@Column(name = "pessoa_rua")
	private String rua;
	@Column(name = "pessoa_bairro")
	private String bairro;
	@Column(name = "pessoa_cidade")
	private String cidade;
	@Column(name = "pessoa_uf")
	private String uf;
	@Column(name = "pessoa_cep")
	private int cep;
	@Column(name = "pessoa_email")
	private String email;
	@Column(name = "pessoa_senha")
	private String senha;
	@Column(name = "pessoa_tipo")
	private String tipo;
	@Column(name = "pessoa_fone1")
	private String fone1;
	@Column(name = "pessoa_fone2")
	private String fone2;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}

	public String getRg() {return rg;}
	public void setRg(String rg) {this.rg = rg;}

	public Date getData_Nasc() {return data_Nasc;}
	public void setData_Nasc(Date data_Nasc) {this.data_Nasc = data_Nasc;}
	
	public String getRua() {return rua;}
	public void setRua(String rua) {this.rua = rua;}
	
	public String getBairro() {return bairro;}
	public void setBairro(String bairro) {this.bairro = bairro;}
	
	public String getCidade() {return cidade;}
	public void setCidade(String cidade) {this.cidade = cidade;}
	
	public String getUf() {return uf;}
	public void setUf(String uf) {this.uf = uf;}
	
	public int getCep() {return cep;}
	public void setCep(int cep) {this.cep = cep;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	public String getFone1() {return fone1;}
	public void setFone1(String fone1) {this.fone1 = fone1;}
	
	public String getFone2() {return fone2;}
	public void setFone2(String fone2) {this.fone2 = fone2;}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + cep;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_Nasc == null) ? 0 : data_Nasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fone1 == null) ? 0 : fone1.hashCode());
		result = prime * result + ((fone2 == null) ? 0 : fone2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep != other.cep)
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data_Nasc == null) {
			if (other.data_Nasc != null)
				return false;
		} else if (!data_Nasc.equals(other.data_Nasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fone1 == null) {
			if (other.fone1 != null)
				return false;
		} else if (!fone1.equals(other.fone1))
			return false;
		if (fone2 == null) {
			if (other.fone2 != null)
				return false;
		} else if (!fone2.equals(other.fone2))
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
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
}