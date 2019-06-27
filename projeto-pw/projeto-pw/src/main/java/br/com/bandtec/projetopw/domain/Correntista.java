package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="correntistas")
public class Correntista {

	@Id
	@GeneratedValue
	private UUID id;
	
	private final String nome;
	@Embedded
	private final CPF cpf;
	
	@Embedded
	private final Endereco endereco;
	
	public Correntista(String nome, String cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = new CPF(cpf);
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}
}
