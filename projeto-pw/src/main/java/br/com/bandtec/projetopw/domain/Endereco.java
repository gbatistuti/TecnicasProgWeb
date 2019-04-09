package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
	//embutível na classe Correntista
public class Endereco {

	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	
	public Endereco() {	}
	
	public Endereco(String logradouro, int numero, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}
	

}
