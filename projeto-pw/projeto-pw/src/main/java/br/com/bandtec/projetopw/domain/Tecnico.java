package br.com.bandtec.projetopw.domain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tecnicos")
public class Tecnico {
	
	@Id
	@GeneratedValue
	private UUID id;
	private final String nome;
	private final BigDecimal salario;
	
	@OneToOne(mappedBy="tecnico")
	private Time time;
	
	public Tecnico(String nome, BigDecimal salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
}
