package br.com.bandtec.projetopw.infra;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.bandtec.projetopw.controller.Credenciais;
import br.com.bandtec.projetopw.repository.TodosUsuarios;

public class SegurancaDaAplicacaoTest {

	private SegurancaDaAplicacao seguranca;
	private TodosUsuarios todosUsuarios;
	private Credenciais credenciais;
	
	@Before
	public void setup() {
		credenciais = new Credenciais("rodrigo", "rodrigo");
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		seguranca = new SegurancaDaAplicacao(todosUsuarios);
	}
	
	@Test
	public void autorizarUsuario() {
		when(todosUsuarios.contemUsuarioComEssas(credenciais)).thenReturn(true);
		Assert.assertTrue(seguranca.permitirAcesso(credenciais));
	}
	
	@Test
	public void naoAutorizarUsuarioPoisUsuarioNaoExiste() {
		when(todosUsuarios.contemUsuarioComEssas(credenciais)).thenReturn(false);
		Assert.assertFalse(seguranca.permitirAcesso(credenciais));
	}
	
	@Test
	public void naoAutorizarUsuarioPoisLoginESenhaNaoConferem() {
		credenciais = new Credenciais("login", "senha");
		when(todosUsuarios.contemUsuarioComEssas(credenciais)).thenReturn(true);
		
		Assert.assertFalse(seguranca.permitirAcesso(credenciais));
	}
}
