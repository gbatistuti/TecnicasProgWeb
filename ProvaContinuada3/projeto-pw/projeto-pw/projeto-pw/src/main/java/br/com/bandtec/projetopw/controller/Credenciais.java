package br.com.bandtec.projetopw.controller;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {

	private String login;
	private String senha;
	
	protected Credenciais() {}
	
	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
