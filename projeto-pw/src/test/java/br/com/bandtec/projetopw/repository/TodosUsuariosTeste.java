package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bandtec.projetopw.domain.Usuario;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosTeste {

	@Autowired
	private TodosUsuarios todosUsuarios;

	@Test
	public void persistirUmUsuario() {
		Usuario gabriel = new Usuario("gabriel", "gabriel");
		todosUsuarios.save(gabriel);

		Usuario usuarioPersistido = todosUsuarios.getOne(gabriel.getID());

		assertEquals(gabriel, usuarioPersistido);
	}

	@Test
	public void buscarUsuarioPorLogin() {
		// 1. Preparar cenário
		// 2. Executar teste
		// 3. Comparar/Analsar resultados
		// 4. Retornar contexto ao estado anterior

		Usuario lohany = new Usuario("Lohany", "Lohany");
		todosUsuarios.save(lohany);

		List<Usuario> usuarios = todosUsuarios.comLogin("Lohany");

		assertTrue(usuarios.contains(lohany));
	}

	@Test
	public void atualizarSenhaDoUsuario() {
		Usuario lohany = new Usuario("Lohany", "Lohany");
		todosUsuarios.save(lohany);

		Usuario usuarioPersistido = todosUsuarios.getOne(lohany.getID());
		usuarioPersistido.atualizarSenha("1234");

		todosUsuarios.save(usuarioPersistido);

		Usuario usuarioAtualizado = todosUsuarios.getOne(lohany.getID());

		assertEquals("1234", usuarioAtualizado.getSenha());
	}

	@Test
	public void removerUmUsuario() {
		Usuario lohany = new Usuario("Lohany", "Lohany");
		todosUsuarios.save(lohany);
		
		todosUsuarios.delete(lohany);
		
		boolean usuarioExiste = todosUsuarios.existsById(lohany.getID());
		assertFalse(usuarioExiste);
	}
}
