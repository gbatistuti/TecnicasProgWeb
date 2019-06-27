package br.com.bandtec.projetopwclient;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.bandtec.projetopwclient.domain.Credenciais;
import br.com.bandtec.projetopwclient.domain.Usuario;

@Component
public class ClienteDeUsuarios {

	private final RestTemplate restTemplate;
	private final String url;
	
	public ClienteDeUsuarios() {
		this.restTemplate = new RestTemplate();
		this.url = "http://localhost:8080/usuarios/";
	}
	
	public void consultarUsuariosPorNome(String nome) {
		Usuario[] usuarios = this.restTemplate.getForObject(this.url + nome, Usuario[].class);
		for(Usuario umUsuario : usuarios) {
			System.out.println(Objects.toString(umUsuario));
		}
	}

	public void inserirNovoUsuario(String login, String senha) {
		Credenciais credenciais = new Credenciais(login, senha);
		Usuario novoUsuario = new Usuario(credenciais);
		
		ResponseEntity<String> resposta = 
				this.restTemplate.postForEntity(url, novoUsuario, String.class);
		
		System.out.println(resposta);
	}
}
