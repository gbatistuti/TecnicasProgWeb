package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.Tecnico;
import br.com.bandtec.projetopw.domain.Time;

@Transactional
@Commit // usar caso queira deixar o registro na base, para mostrar o registro na base via select no banco.
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosTimesTest {
	
	@Autowired
	private TodosTimes todosTimes;
	
	private Time corinthians;
	
	@Before
	public void setUp() {
		Tecnico fabioCarille = new Tecnico("Fabio Carille", new BigDecimal("600000"));
		corinthians = new Time("Corinthians", LocalDate.of(1910, 9, 1), fabioCarille);
	}
	
	@Test
	public void persistirUmTime() {
		todosTimes.save(corinthians);
		
		Time timeEncontrado = todosTimes.getOne(corinthians.getId());
		
		assertEquals(corinthians, timeEncontrado);
	}
}
