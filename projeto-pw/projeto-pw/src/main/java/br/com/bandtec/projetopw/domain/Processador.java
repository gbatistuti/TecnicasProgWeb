package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="processadores")
public class Processador {
	
	@Id
	private UUID id;
	
	private String marca;
	private String modelo;
	private Integer numeroDeNucleos;
	
	@OneToOne
	@JoinColumn(name="id")
	@MapsId
	private Computador computador;
	
	protected Processador() {}
	
	public Processador(String marca, String modelo, Integer numeroDeNucleos) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.numeroDeNucleos = numeroDeNucleos;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}
}
