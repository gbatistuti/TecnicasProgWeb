package br.com.bandtec.projetopw.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="editoras")
public class Editora {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	
	@OneToMany(mappedBy = "editora")
	private List<Revista> revistas;
	
	public Editora() {}

	public Editora(String nome) {
		this.nome = nome;
	}
	
	
	
}
