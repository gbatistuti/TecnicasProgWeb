package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "usuarios")
public class Usuario {

	@Id @GeneratedValue
	private UUID id;
	private String login;
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String login, String senha){ 
		this.login = login;
		this.senha = senha;
	}
	
	public UUID getID() {
		return id;
	}

	public void atualizarSenha(String senha) {
		this.senha = senha;
	}

	public Object getSenha() {
		return this.senha;
	}


	
	
}
