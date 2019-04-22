package br.com.bandtec.projetopw.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.ContaCorrente;

@Repository
public interface TodasContasCorrente extends JpaRepository<ContaCorrente, UUID> {

	@Query("from ContaCorrente where banco = ?1")
	List<ContaCorrente> doBanco(String banco);

}
