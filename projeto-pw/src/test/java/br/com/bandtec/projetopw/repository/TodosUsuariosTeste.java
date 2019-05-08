package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.Embedded;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bandtec.projetopw.controller.Credenciais;
import br.com.bandtec.projetopw.domain.Usuario;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosTeste {

	@Autowired
	private TodosUsuarios todosUsuarios;
	
	@Embedded
	private Credenciais credenciais;
	private Usuario usuario;
	
	@Before
	public void setUp() {
		credenciais = new Credenciais("gabriel", "gabiel");
		usuario = new Usuario(credenciais);
	}

	@Test
	public void persistirUmUsuario() {
		todosUsuarios.save(usuario);

		Usuario usuarioPersistido = todosUsuarios.getOne(usuario.getID());

		assertEquals(usuario, usuarioPersistido);
	}

	@Test
	public void buscarUsuarioPorLogin() {
		// 1. Preparar cenário
		// 2. Executar teste
		// 3. Comparar/Analsar resultados
		// 4. Retornar contexto ao estado anterior

		todosUsuarios.save(usuario);

		List<Usuario> usuarios = todosUsuarios.comLogin("gabriel");
		assertTrue(usuarios.contains(usuario));
	}

	@Test
	public void atualizarSenhaDoUsuario() {
		todosUsuarios.save(usuario);

		Usuario usuarioPersistido = todosUsuarios.getOne(usuario.getID());
		usuarioPersistido.atualizarSenha("1234");

		todosUsuarios.save(usuarioPersistido);

		Usuario usuarioAtualizado = todosUsuarios.getOne(usuario.getID());

		assertEquals("1234", usuarioAtualizado.getSenha());
	}

	@Test
	public void removerUmUsuario() {
		todosUsuarios.save(usuario);
		
		todosUsuarios.delete(usuario);
		
		boolean usuarioExiste = todosUsuarios.existsById(usuario.getID());
		assertFalse(usuarioExiste);
	}
}
