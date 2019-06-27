package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
public class CPF {
	
	private String cpf;
	
	private CPF() {
		
	}
	
	public CPF(String cpf) {
		this.cpf = cpf;
	}
}
