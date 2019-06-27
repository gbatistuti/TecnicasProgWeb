package br.com.bandtec.projetopw.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.Time;

@Repository
public interface TodosTimes extends JpaRepository<Time, UUID> {

}
