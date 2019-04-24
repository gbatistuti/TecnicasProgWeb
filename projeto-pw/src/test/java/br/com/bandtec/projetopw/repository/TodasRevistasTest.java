package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.Editora;
import br.com.bandtec.projetopw.domain.Revista;

@Transactional
//@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasRevistasTest {

	private Revista novaVeja;
	
	@Autowired
	private TodasRevistas todasRevistas;
	
	private String nomeRevista = "Nova Veja";
	 
	@Before
	public void setUp() {
		Editora nova = new Editora("Nova");
		novaVeja = new Revista(nomeRevista, 12, nova);
		todasRevistas.save(novaVeja);
	}
	
	@Test
	public void persistirUmaRevista() {
		Revista revistaPersistida = todasRevistas.getOne(novaVeja.getId());
		assertEquals(novaVeja, revistaPersistida);
	}
	
	@Test
	public void buscarUmaRevistaPeloSeuNome() {
		Revista revistaEncontrada = todasRevistas.comNome(nomeRevista);
		assertEquals(novaVeja, revistaEncontrada);
	}
}
