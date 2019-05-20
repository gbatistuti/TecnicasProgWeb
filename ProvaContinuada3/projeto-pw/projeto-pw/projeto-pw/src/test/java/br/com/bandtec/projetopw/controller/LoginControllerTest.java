package br.com.bandtec.projetopw.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.bandtec.projetopw.infra.SegurancaDaAplicacao;

public class LoginControllerTest {
	
	private LoginController controller;
	
	@Test
	public void aoDigitarLoginESenhaValidosAbrirTelaPrincipal() {
		Credenciais credenciais = new Credenciais("login", "senha");
		SegurancaDaAplicacao seguranca = Mockito.mock(SegurancaDaAplicacao.class);
		Mockito.when(seguranca.permitirAcesso(credenciais)).thenReturn(true);
		controller = new LoginController(seguranca);
		
		String telaPrincipal = controller.efetuarLogin(credenciais);
		
		Assert.assertEquals("paginaPrincipal", telaPrincipal);
	}
	
	@Test
	public void aoDigitarLoginEOuSenhaErradosExibirPaginaDeErro() {
		Credenciais credenciais = new Credenciais("login", "senha");
		SegurancaDaAplicacao seguranca = Mockito.mock(SegurancaDaAplicacao.class);
		Mockito.when(seguranca.permitirAcesso(credenciais)).thenReturn(false);
		controller = new LoginController(seguranca);
		
		String paginaDeErro = controller.efetuarLogin(credenciais);
		
		Assert.assertEquals("paginaDeErro", paginaDeErro);
	}
}
