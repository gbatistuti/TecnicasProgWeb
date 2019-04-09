package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "correntistas")
// determina qual a tabela e o nome dela,
// caso não coloque, a tabela vai com o nome da classe
public class Correntista {

	@Id
	@GeneratedValue
	// o sistema quem está gerando o valor do id que será
	// persistido no banco de dados
	private UUID id;

	private Nome nome;
	private Cpf cpf;

	@Embedded
	// o Endereço está embutido no Correntista
	private Endereco endereco;

	public Correntista() {
	}

	public Correntista(Nome nome, Cpf cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}

}
