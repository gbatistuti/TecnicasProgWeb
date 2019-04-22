package br.com.bandtec.projetopw.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bandtec.projetopw.domain.ContaCorrente;
import br.com.bandtec.projetopw.domain.Lancamento;

public interface TodosLancamentos extends JpaRepository<Lancamento, UUID> {

	@Query("from Lancamento where contaCorrente = ?1")
	List<Lancamento> daContaCorrente(ContaCorrente contaCorrente);

}
