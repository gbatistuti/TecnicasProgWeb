package br.com.bandtec.projetopw.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="times")
public class Time {
	
	@Id
	@GeneratedValue
	private UUID id;
	private final String nome;
	private final LocalDate fundacao;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="tecnico_id")
	
	@JoinColumn(name="id")
	@MapsId
	
	private final Tecnico tecnico;
	
	public Time(String nome, LocalDate fundacao, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.fundacao = fundacao;
		this.tecnico = tecnico;
	}

	public UUID getId() {
		return id;
	}
}
