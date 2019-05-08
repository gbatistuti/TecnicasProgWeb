package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.bandtec.projetopw.controller.Credenciais;

@Entity @Table(name = "usuarios")
public class Usuario {

	@Id @GeneratedValue
	private UUID id;
	@JsonProperty
	private Credenciais credenciais;
	
	public Usuario() {}
	
	public Usuario(Credenciais credenciais){ 
		this.credenciais = credenciais;
	}
	
	public UUID getID() {
		return id;
	}

	public void atualizarSenha(String senha) {
		credenciais.setSenha(senha);
	}

	@JsonIgnore
	public String getSenha() {
		return credenciais.getSenha();
	}

}
