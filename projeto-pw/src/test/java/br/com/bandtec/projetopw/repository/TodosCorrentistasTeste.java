package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bandtec.projetopw.domain.Correntista;
import br.com.bandtec.projetopw.domain.Cpf;
import br.com.bandtec.projetopw.domain.Endereco;
import br.com.bandtec.projetopw.domain.Nome;

@Transactional
//@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosCorrentistasTeste {
	
	@Autowired
	private TodosCorrentistas todosCorrentistas;

	private Correntista correntista;
	private Nome nome;
	private Cpf cpf;
	private Endereco endereco;
	
	@Before
	public void setup() {
		endereco = new Endereco("Rua Haddock Lobo", 595, "Disney", "Vegetativo");
		nome = new Nome("Luis");
		cpf = new Cpf("789456");
		correntista = new Correntista(nome, cpf, endereco);
	}
	
	
	@Test
	public void persistirUmCorrentista() {
		todosCorrentistas.save(correntista);
		
		Correntista correntistaPersistido = todosCorrentistas.getOne(correntista.getId());
		
		assertEquals(correntistaPersistido, correntista);
		
	}
	
	@Test
	public void buscarUmCorrentistaPorCpf() {
		todosCorrentistas.save(correntista);
		
		Correntista correntistaPersistido = todosCorrentistas.comCpf(cpf);
		
		assertEquals(correntistaPersistido, correntista);
		
	}
	
	
}
