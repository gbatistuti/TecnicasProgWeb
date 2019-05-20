package br.com.bandtec.projetopw.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultaNoSUS")
public class ConsultaNoSUS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private Date data;
	private String especialidade;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "consultas")
	private Cidadao cidadao;
	
	protected ConsultaNoSUS() {}
	
	public ConsultaNoSUS(Date data, String especialidade) {
		this.data = data;
		this.especialidade = especialidade;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	
	
}
