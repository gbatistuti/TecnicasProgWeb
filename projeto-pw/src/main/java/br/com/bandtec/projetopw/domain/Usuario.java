package br.com.bandtec.projetopw.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private UUID id;
	private String login;
	private String senha;
	
	protected Usuario() {}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public UUID getId() {
		return id;
	}

	public void atualizarSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	public String getSenha() {
		return senha;
	}
}
