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

import br.com.bandtec.projetopw.domain.Computador;
import br.com.bandtec.projetopw.domain.Processador;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosComputadoresTest {
	
	@Autowired
	private TodosComputadores todosComputadores;
	
	private Computador computador;
	
	@Before
	public void setUp() {
		Processador processador = new Processador("Intel", "Core I5", 8);
		computador = new Computador("Dell", "Vostro", processador);
		
		todosComputadores.save(computador);
	}
	
	@Test
	public void persistirUmComputador() {
		Computador computadorEncontrado = todosComputadores.getOne(computador.getId());
		
		assertEquals(computadorEncontrado, computador);
	}
	
	@Test
	public void buscarComputadoresPorModelo() {
		List<Computador> computadoresEncontrados = todosComputadores.findByModelo("Vostro");
		
		assertTrue(computadoresEncontrados.contains(computador));
	}
	
	@Test
	public void buscarComputadoresPorMarcaEModelo() {
		List<Computador> computadoresEncontrados = todosComputadores.findByMarcaAndModelo("Dell", "Vostro");
		
		assertTrue(computadoresEncontrados.contains(computador));
	}
}
