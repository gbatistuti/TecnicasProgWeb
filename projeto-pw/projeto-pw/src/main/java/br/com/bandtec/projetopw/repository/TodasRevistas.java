package br.com.bandtec.projetopw.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.Revista;

@Repository
public interface TodasRevistas extends JpaRepository<Revista, UUID> {

	@Query("from Revista where nomeRevista = ?1")
	Revista comNome(String nomeRevista);

}
