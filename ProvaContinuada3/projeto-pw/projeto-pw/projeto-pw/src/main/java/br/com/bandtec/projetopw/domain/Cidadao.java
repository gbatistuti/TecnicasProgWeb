package br.com.bandtec.projetopw.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidadao")
public class Cidadao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nome;
	
	@Embedded
	private CPF cpf;
	private Integer idade;
	
	@OneToMany(mappedBy = "cidadao")
	private List<ConsultaNoSUS> consultas;
	
	protected Cidadao() {}
	
	public Cidadao(String nome, CPF cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.consultas = new ArrayList<>();
	}

	public void inserir(ConsultaNoSUS consulta) {
		this.consultas.add(consulta);
		consulta.setCidadao(this);
	}

	public UUID getId() {
		return id;
	}

	public boolean contem(ConsultaNoSUS consulta) {
		return consultas.contains(consulta);
	}

	public void atualizarIdade(int novaIdade) {
		this.idade = novaIdade;
		
	}

	public int lerIdade() {
		return idade;
	}
}
