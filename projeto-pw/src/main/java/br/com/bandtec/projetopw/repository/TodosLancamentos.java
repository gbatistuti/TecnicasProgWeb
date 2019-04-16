package br.com.bandtec.projetopw.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.ContaCorrente;
import br.com.bandtec.projetopw.domain.Lancamento;


@Repository
public interface TodosLancamentos extends JpaRepository<Lancamento, UUID> {

	@Query("from Lancamento where contaCorrente = ?1")
	List<Lancamento> daConta(ContaCorrente contaCorrente);

}
