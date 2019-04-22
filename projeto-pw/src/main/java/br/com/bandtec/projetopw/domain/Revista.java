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
@Table(name="revistas")
public class Revista {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private Integer edicao;
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="editora_id")
	private Editora editora;

	public Revista(String nome, Integer edicao, Editora editora) {
		this.nome = nome;
		this.edicao = edicao;
		this.editora = editora;
	}
	
	public Revista() {}

	public UUID getId() {
		return id;
	}

	
}
