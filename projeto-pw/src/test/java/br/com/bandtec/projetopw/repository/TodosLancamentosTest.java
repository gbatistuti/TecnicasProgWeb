package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
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
public class TodosLancamentosTest {
	
	private ContaCorrente contaCorrente;
	
	@Autowired
	private TodosLancamentos todosLancamentos;
	
	@Before
	public void setUp() {
		contaCorrente = new ContaCorrente("033", "3037", "4444-4");
		
	}
	
	@Test
	public void persistirUmLancamento() {
		Lancamento compraCamisa = new Lancamento("camisa", 30.00, contaCorrente);
		
		todosLancamentos.save(compraCamisa);
		
		Lancamento lancamentoSalvo = todosLancamentos.getOne(compraCamisa.getId());
		
		assertEquals(compraCamisa, lancamentoSalvo);
	}
	
	@Test
	public void buscarLancamentosDeUmaContaCorrenteEspecifica() {
		Lancamento compraCamisa = new Lancamento("camisa", 30.00, contaCorrente);
		Lancamento compraCalca = new Lancamento("calça", 50.00, contaCorrente);
		
		todosLancamentos.save(compraCamisa);
		todosLancamentos.save(compraCalca);
		
		List<Lancamento> lancamentosDaConta = todosLancamentos.daContaCorrente(contaCorrente);
		
		assertTrue(lancamentosDaConta.contains(compraCalca));
		assertTrue(lancamentosDaConta.contains(compraCamisa));
	}
}
