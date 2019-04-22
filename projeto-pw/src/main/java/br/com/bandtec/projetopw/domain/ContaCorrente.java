package br.com.bandtec.projetopw.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contas_corrente")
public class ContaCorrente {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String banco;
	private String agencia;
	private String conta;
	
	@OneToMany(mappedBy="contaCorrente")
	private List<Lancamento> lancamentos;
	
	protected ContaCorrente() {}
	
	public ContaCorrente(String banco, String agencia, String conta) {
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.lancamentos = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public void atualizarAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAgencia() {
		return agencia;
	}

	public void adicionar(Lancamento umLancamento) {
		this.lancamentos.add(umLancamento);
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
}
