package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.CPF;
import br.com.bandtec.projetopw.domain.Cidadao;

@Transactional
//@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosCidadaosTest {
	
	@Autowired
	private TodosCidadaos todosCidadaos;
	
	private Cidadao pacheco;
	private CPF cpf;
	
	@Before
	public void setUp() {
		cpf = new CPF("90325435804");
		pacheco = new Cidadao("Pacheco dos Santos", cpf, 33);
		todosCidadaos.save(pacheco);
	}
	
	@Test
	public void persistirPacheco() {
		Cidadao pachecoEncontrado = todosCidadaos.getOne(pacheco.getId());
		
		assertEquals(pacheco, pachecoEncontrado);
	}
	
	@Test
	public void atualizarPacheco() {
		Cidadao pachecoParaAtualizar = todosCidadaos.getOne(pacheco.getId());

		pachecoParaAtualizar.atualizarIdade(40);
		todosCidadaos.save(pacheco);
		
		Cidadao pachecoAtualizado = todosCidadaos.getOne(pacheco.getId());
		
		assertEquals(40, pachecoAtualizado.lerIdade());
	}

	@Test
	public void buscarPachecoPorCPF() {
		Cidadao pachecoEncontrado = todosCidadaos.comCpf(cpf);
		
		assertEquals(pacheco, pachecoEncontrado);
	}
	
	@Test
	public void removerPacheco() {
		Cidadao pachecoEncontrado = todosCidadaos.getOne(pacheco.getId());
		
		assertNotNull(pachecoEncontrado);
		
		todosCidadaos.delete(pacheco);
		
		assertFalse(todosCidadaos.existsById(pacheco.getId()));
	}
}

