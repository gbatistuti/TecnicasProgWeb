package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Nome {
	
	private String nome;
	
	public Nome() {}

	public Nome(String nome) {
		this.nome = nome;
	}
	
	

}
