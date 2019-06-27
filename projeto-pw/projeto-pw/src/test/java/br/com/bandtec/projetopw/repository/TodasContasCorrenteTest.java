package br.com.bandtec.projetopw.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
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

import br.com.bandtec.projetopw.domain.ContaCorrente;
import br.com.bandtec.projetopw.domain.Lancamento;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasContasCorrenteTest {

	@Autowired
	private TodasContasCorrente todasContasCorrente;
	    
	private ContaCorrente contaCorrente;
	
	@Before
	public void setUp() {
		contaCorrente = new ContaCorrente("033", "3038", "99888-1");
	}
	
	@Test
	public void persistirUmaContaCorrente() {
		todasContasCorrente.save(contaCorrente);
		
		ContaCorrente contaEncontrada = todasContasCorrente.getOne(contaCorrente.getId());
		
		assertEquals(contaCorrente, contaEncontrada);
	}
	
	@Test
	public void buscarUmaContaCorrentePorBanco() {
		todasContasCorrente.save(contaCorrente);
		
		List<ContaCorrente> usuariosObtidos = todasContasCorrente.doBanco("033");
		
		assertTrue(usuariosObtidos.contains(contaCorrente));
	}

	@Test
	public void atualizarUmaContaCorrente() {
		todasContasCorrente.save(contaCorrente);
		
		ContaCorrente paraAtualizar = todasContasCorrente.getOne(contaCorrente.getId());
		String novaAgencia = "4444";
		paraAtualizar.atualizarAgencia(novaAgencia);
		todasContasCorrente.save(paraAtualizar);
		
		ContaCorrente contaAtualizada = todasContasCorrente.getOne(contaCorrente.getId());
		
		assertEquals(novaAgencia, contaAtualizada.getAgencia());
	}
	
	@Test
	public void removerUmaContaCorrente() {
		todasContasCorrente.save(contaCorrente);
		
		// opcional
		ContaCorrente contaEncontrada = todasContasCorrente.getOne(contaCorrente.getId());
		assertEquals(contaCorrente, contaEncontrada);
		
		todasContasCorrente.delete(contaCorrente);
		
		boolean usuarioExiste = todasContasCorrente.existsById(contaEncontrada.getId());
		assertFalse(usuarioExiste);
	}
	
	@Test
	public void adicionarUmaContaCorrenteComLancamento() {
		Lancamento umLancamento = new Lancamento("roupa", 10.00, contaCorrente);
		contaCorrente.adicionar(umLancamento);
		
		todasContasCorrente.save(contaCorrente);
		
		ContaCorrente contaEncontrada = todasContasCorrente.getOne(contaCorrente.getId());
		
		assertThat(contaEncontrada, is(equalTo(contaCorrente)));
		assertTrue(contaEncontrada.getLancamentos().contains(umLancamento));
	}
}
