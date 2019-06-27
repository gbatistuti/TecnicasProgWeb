package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	
	private Endereco() {}
	
	public Endereco(String logradouro, int numero, String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}
}
