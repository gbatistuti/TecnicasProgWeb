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
	private String descricao;
	private Double valor;
	
	@ManyToOne(cascade=CascadeType.ALL)
		//cascadeType.ALL é bom para testes, pois se apagar um lançamento, ele apaga a conta também
	@JoinColumn(name="conta_corrente_id")
	private ContaCorrente contaCorrente;
	
	public Lancamento(String descricao, double valor, ContaCorrente contaCorrente) {
		this.descricao = descricao;
		this.valor = valor;
		this.contaCorrente = contaCorrente;
	}

	public UUID getId() {
		return id;
	}
	
	
}
