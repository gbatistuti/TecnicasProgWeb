package br.com.bandtec.projetopw.domain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pagamentos")
public class Pagamento {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private final BigDecimal total;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="detalhes_id")
	private final DetalhesPagamento detalhes;

	public Pagamento(BigDecimal total, DetalhesPagamento detalhes) {
		this.total = total;
		this.detalhes = detalhes;
	}

	public UUID getId() {
		return id;
	}
}
