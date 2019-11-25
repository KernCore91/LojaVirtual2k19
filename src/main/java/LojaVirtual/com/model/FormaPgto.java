package LojaVirtual.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formapgto")
public class FormaPgto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formapgto_id")
	private Long id;
	@Column(name = "formapgto_descricao")
	private String descricao;
	@Column(name = "formapgto_num_Max_Parc")
	private int num_Max_Parc;
	@Column(name = "formapgto_Padrao_Parc")
	private int num_Padrao_Parc;
	@Column(name = "formapgto_intervalo_Dias")
	private int intervalo_Dias;
	@Column(name = "formapgto_percentual_Acres")
	private double percentual_Acres;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	
	public int getNum_Max_Parc() {return num_Max_Parc;}
	public void setNum_Max_Parc(int num_Max_Parc) {this.num_Max_Parc = num_Max_Parc;}
	
	public int getNum_Padrao_Parc() {return num_Padrao_Parc;}
	public void setNum_Padrao_Parc(int num_Padrao_Parc) {this.num_Padrao_Parc = num_Padrao_Parc;}
	
	public int getIntervalo_Dias() {return intervalo_Dias;}
	public void setIntervalo_Dias(int intervalo_Dias) {this.intervalo_Dias = intervalo_Dias;}
	
	public double getPercentual_Acres() {return percentual_Acres;}
	public void setPercentual_Acres(double percentual_Acres) {this.percentual_Acres = percentual_Acres;}
}
