package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.DetalhesPagamento;
import br.com.bandtec.projetopw.domain.FormaDePagamento;
import br.com.bandtec.projetopw.domain.Pagamento;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosPagamentosTest {
	
	@Autowired
	private TodosPagamentos todosPagamentos;
	
	private Pagamento umPagamento;
	private DetalhesPagamento detalhesPagamento;
	
	@Before
	public void setUp() {
		DetalhesPagamento detalhes = new DetalhesPagamento(FormaDePagamento.CARTAO, Instant.now());
		umPagamento = new Pagamento(BigDecimal.TEN, detalhes);
	}
	
	@Test
	public void persistirUmPagamento() {
		todosPagamentos.save(umPagamento);
		
		Pagamento pagamentoSalvo = todosPagamentos.getOne(umPagamento.getId());
		
		assertEquals(umPagamento, pagamentoSalvo);
	}
}
