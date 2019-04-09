package br.com.bandtec.projetopw.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.Correntista;
import br.com.bandtec.projetopw.domain.Cpf;

@Repository
public interface TodosCorrentistas extends JpaRepository<Correntista, UUID> {

	@Query("from Correntista where cpf = ?1")
	Correntista comCpf(Cpf cpf);
	
	

}
