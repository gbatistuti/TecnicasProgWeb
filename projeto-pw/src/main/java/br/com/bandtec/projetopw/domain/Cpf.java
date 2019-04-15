package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Cpf {

	private String cpf;
	
	public Cpf() {}

	public Cpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}


	
	
}
