package br.com.bandtec.projetopwclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
	
	//private UUID id;
	private Credenciais credenciais;
	
	protected Usuario() {}
	
	public Usuario(Credenciais credenciais) {
		this.credenciais = credenciais;
	}
	public Credenciais getCredenciais() {
		return credenciais;
	}
	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}
	/*public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}*/
	@Override
	public String toString() {
		return "Usuario [credenciais=" + credenciais + "]";
	}
}
