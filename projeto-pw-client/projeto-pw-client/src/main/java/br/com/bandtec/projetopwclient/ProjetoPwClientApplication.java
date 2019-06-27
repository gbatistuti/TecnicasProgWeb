package br.com.bandtec.projetopwclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoPwClientApplication {

	public static void main(String[] args) {
		ClienteDeUsuarios cliente = SpringApplication
				.run(ProjetoPwClientApplication.class, args)
				.getBean(ClienteDeUsuarios.class);
		
		cliente.inserirNovoUsuario("lucas", "lucas");
		cliente.consultarUsuariosPorNome("lucas");
		
		System.exit(0);
	}

}
