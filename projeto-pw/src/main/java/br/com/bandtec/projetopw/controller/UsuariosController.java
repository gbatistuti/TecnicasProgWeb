package br.com.bandtec.projetopw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.projetopw.domain.Usuario;
import br.com.bandtec.projetopw.repository.TodosUsuarios;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private TodosUsuarios todosUsuarios;
	
	@GetMapping("/{nome}")
	public List<Usuario> obterUsuariosDeNome(@PathVariable("nome") String nome){
		return todosUsuarios.comNome(nome);
	}

	@PostMapping
	public ResponseEntity<String> criarNovoUsuario(@RequestBody Usuario usuario){
		todosUsuarios.save(usuario);
		//return ResponseEntity.ok("Usuário inserido com sucesso");
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário inserido com sucesso");
	}
}
