package br.com.bandtec.projetopw.domain;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalhes_pagamento")
public class DetalhesPagamento {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	private final FormaDePagamento formaDePagamento;
	
	@OneToOne(mappedBy="detalhes")
	private Pagamento pagamento;
	
	private final Instant data;

	public DetalhesPagamento(FormaDePagamento formaDePagamento, Instant data) {
		this.formaDePagamento = formaDePagamento;
		this.data = data;
	}
}
