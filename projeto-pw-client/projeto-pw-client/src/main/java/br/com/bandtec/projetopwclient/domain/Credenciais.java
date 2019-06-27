package br.com.bandtec.projetopwclient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credenciais {
	
	@JsonProperty
	private String login;
	
	@JsonProperty
	private String senha;
	
	protected Credenciais() {}

	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Credenciais [login=" + login + ", senha=" + senha + "]";
	}
	
	/*
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
	}*/
}
