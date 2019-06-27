package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lancamentos")
public class Lancamento {
	
	@Id
	@GeneratedValue
	private UUID id;
	private final String descricao;
	private final double valor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="conta_corrente_id")
	private final ContaCorrente contaCorrente;
	
	public Lancamento(String descricao, double valor, ContaCorrente contaCorrente) {
		this.descricao = descricao;
		this.valor = valor;
		this.contaCorrente = contaCorrente;
	}

	public UUID getId() {
		return id;
	}
}
