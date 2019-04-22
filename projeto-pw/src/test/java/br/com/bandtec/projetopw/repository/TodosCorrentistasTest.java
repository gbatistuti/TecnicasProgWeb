package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.Correntista;
import br.com.bandtec.projetopw.domain.Endereco;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosCorrentistasTest {
	
	@Autowired
	private TodosCorrentistas todosCorrentistas;
	
	private Endereco endereco;
	private Correntista correntista;
	
	@Before
	public void setUp() {
		endereco = new Endereco("Rua a", 45, "São Paulo", "SP");
		correntista = new Correntista("Cacilda", "44398709600", endereco);
	}
	
	@Test
	public void persistirUmCorrentista() {
		todosCorrentistas.save(correntista);
		
		Correntista correntistaPersistido = todosCorrentistas.getOne(correntista.getId());
		
		assertEquals(correntista, correntistaPersistido);
	}
}
