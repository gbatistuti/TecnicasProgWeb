package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bandtec.projetopw.domain.ContaCorrente;
import br.com.bandtec.projetopw.domain.Lancamento;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosLancamentosTest {
	
	private ContaCorrente contaCorrente;
	
	@Autowired
	private TodosLancamentos todosLancamentos;
	private Lancamento comida;
	
	@Before
	public void rodarAntesDeCadaTeste() {
		contaCorrente = new ContaCorrente("260", "001", "3453");
		comida = new Lancamento("comida", 15.00, contaCorrente);
		todosLancamentos.save(comida);
	}
	
	@Test
	public void persistirUmLancamento() {

		Lancamento lancamentoSalvo = todosLancamentos.getOne(comida.getId());
		assertEquals(comida, lancamentoSalvo);
	}
	@Test
	public void buscarLancamentosDeUmaContaCorrenteEspecifica() {
		List<Lancamento> lancamentos = todosLancamentos.daConta(contaCorrente);
		assertTrue(lancamentos.contains(comida));
		
	}

}
