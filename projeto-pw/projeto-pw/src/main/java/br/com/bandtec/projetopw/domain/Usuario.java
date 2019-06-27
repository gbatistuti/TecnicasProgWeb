package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.bandtec.projetopw.controller.Credenciais;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Embedded
	@JsonProperty
	private Credenciais credenciais;
	
	protected Usuario() {}
	
	public Usuario(String login, String senha) {
		this.credenciais = new Credenciais(login, senha);
	}

	public UUID getId() {
		return id;
	}

	public void atualizarSenha(String novaSenha) {
		this.credenciais.setSenha(novaSenha);
	}

	@JsonIgnore
	public String getSenha() {
		return this.credenciais.getSenha();
	}
}
