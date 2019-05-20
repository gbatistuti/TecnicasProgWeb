package br.com.bandtec.projetopw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.bandtec.projetopw.infra.SegurancaDaAplicacao;

@Controller
public class LoginController {

	private final SegurancaDaAplicacao seguranca;
	
	public LoginController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String efetuarLogin(@ModelAttribute Credenciais credenciais) {
		if(seguranca.permitirAcesso(credenciais)) return "paginaPrincipal";
		else return "paginaDeErro";
	}
	
	@GetMapping("/login")
	public String exibirPaginaDeLogin(Model model) {
		model.addAttribute(new Credenciais(null, null));
		return "paginaDeLogin";
	}
}
