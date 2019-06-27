package br.com.bandtec.projetopw.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.Computador;

@Repository
public interface TodosComputadores extends JpaRepository<Computador, UUID> {

	List<Computador> findByModelo(String modelo);

	List<Computador> findByMarcaAndModelo(String marca, String modelo);
	
	
}
