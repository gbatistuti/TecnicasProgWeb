package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="revistas")
public class Revista {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name="nome_revista")
	private String nomeRevista;
	private int edicao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="editora_id")
	private Editora editora;
	
	public Revista(String nomeRevista, int edicao, Editora editora) {
		this.nomeRevista = nomeRevista;
		this.edicao = edicao;
		this.editora = editora;
	}

	public UUID getId() {
		return id;
	}

}
