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

import br.com.bandtec.projetopw.domain.ContaCorrente;

@Transactional @Commit @SpringBootTest @RunWith(SpringRunner.class)
public class TodasContasCorrenteTeste {
	
	@Autowired
	private TodasContasCorrentes todasContasCorrentes;
	
	@Test
	public void persistirUmaContaCorrente() {
		ContaCorrente contaCorrente = new ContaCorrente("033", "3038", "99888-1");
		todasContasCorrentes.save(contaCorrente);
		
		ContaCorrente contaEncontrada = todasContasCorrentes.getOne(contaCorrente.getId());
		
		assertEquals(contaCorrente, contaEncontrada);

	}
	
	@Test
	public void buscarContaCorrentePorConta() {
		ContaCorrente contaCorrente = new ContaCorrente("033", "3038", "99888-1");
		todasContasCorrentes.save(contaCorrente);
		
		List<ContaCorrente> conta = todasContasCorrentes.comConta("99888-1");
		
		assertTrue(conta.contains(contaCorrente));
	}
	
	
	@Test
	public void atualizarContaDaContaCorrente() {
		ContaCorrente contaCorrente = new ContaCorrente("033", "3038", "99888-1");
		todasContasCorrentes.save(contaCorrente);
		
		ContaCorrente contaPersistida = todasContasCorrentes.getOne(contaCorrente.getId());
		contaPersistida.atualizarConta("99777-2");
		
		todasContasCorrentes.save(contaPersistida);
		
		ContaCorrente contaAtualizada = todasContasCorrentes.getOne(contaCorrente.getId());
		
		assertEquals("99777-2", contaAtualizada.getConta());
	}
	
	@Test
	public void removerConta() {
		ContaCorrente contaCorrente = new ContaCorrente("033", "3038", "99888-1");
		todasContasCorrentes.save(contaCorrente);
		
		todasContasCorrentes.delete(contaCorrente);
		
		boolean ContaExiste = todasContasCorrentes.existsById(contaCorrente.getId());
		assertFalse(ContaExiste);
	}

}
