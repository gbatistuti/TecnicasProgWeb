package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="computadores")
public class Computador {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String marca;
	private String modelo;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="computador")
	private Processador processador;
	
	protected Computador() {}
	
	public Computador(String marca, String modelo, Processador processador) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.processador = processador;
		this.processador.setComputador(this);
	}

	public UUID getId() {
		return id;
	}
	
	
}
