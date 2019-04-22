package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.Usuario;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosTest {
	
	@Autowired
	private TodosUsuarios todosUsuarios;
	    
	private Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario("rodrigo", "senha");
	}
	
	@Test
	public void persistirUmUsuario() {
		todosUsuarios.save(usuario);
		
		Usuario usuarioEncontrado = todosUsuarios.getOne(usuario.getId());
		
		assertEquals(usuario, usuarioEncontrado);
	}
	
	@Test
	public void buscarUmUsuarioPorNome() {
		todosUsuarios.save(usuario);
		
		List<Usuario> usuariosObtidos = todosUsuarios.comNome("rodrigo");
		
		assertTrue(usuariosObtidos.contains(usuario));
	}

	@Test
	public void atualizarUmUsuario() {
		todosUsuarios.save(usuario);
		
		Usuario usuarioParaAtualizar = todosUsuarios.getOne(usuario.getId());
		String novaSenha = "novaSenha";
		usuarioParaAtualizar.atualizarSenha(novaSenha);
		todosUsuarios.save(usuarioParaAtualizar);
		
		Usuario usuarioAtualizado = todosUsuarios.getOne(usuario.getId());
		
		assertEquals(novaSenha, usuarioAtualizado.getSenha());
	}
	
	@Test
	public void removerUmUsuario() {
		todosUsuarios.save(usuario);
		
		// opcional
		Usuario usuarioEncontrado = todosUsuarios.getOne(usuario.getId());
		assertEquals(usuario, usuarioEncontrado);
		
		todosUsuarios.delete(usuario);
		
		boolean usuarioExiste = todosUsuarios.existsById(usuario.getId());
		assertFalse(usuarioExiste);
	}
}
