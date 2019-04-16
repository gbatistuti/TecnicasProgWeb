package br.com.bandtec.projetopw.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "contasCorrentes")
public class ContaCorrente {
	@Id @GeneratedValue
	private UUID id;
	private String banco;
	private String agencia;
	private String conta;
	
	@OneToMany(mappedBy="contaCorrente")
	private List<Lancamento> lancamentos;
	
	public ContaCorrente() {}
	
	public ContaCorrente(String banco, String agencia, String conta) {
		super();
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
	}

	public UUID getId() {
		return id;
	}

	public void atualizarConta(String conta) {
		
		this.conta = conta;
		
	}

	public Object getConta() {
		return this.conta;
	}

	
	

}
