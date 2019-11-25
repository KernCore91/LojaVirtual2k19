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
}