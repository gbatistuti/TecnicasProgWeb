package br.com.bandtec.projetopw.controller;

import java.util.List;

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
	
	private final TodosUsuarios todosUsuarios;
	
	public UsuariosController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	
	@GetMapping(value="/{nome}")
	public List<Usuario> obterUsuarioDeNome(@PathVariable("nome") String nome) {
		List<Usuario> usuarios = todosUsuarios.comNome(nome);
		return usuarios;
	}
	
	@PostMapping
	public ResponseEntity<String> criarNovoUsuario(@RequestBody Usuario usuario){
		try {
			todosUsuarios.save(usuario);
			return ResponseEntity.ok("usuario inserido com sucesso");
		}
		catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("erro interno no servidor");
		}
	}
}
