package br.com.bandtec.projetopw.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.controller.Credenciais;
import br.com.bandtec.projetopw.domain.Usuario;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, UUID> {

	@Query("select count (u) > 0 from Usuario u where u.credenciais = ?1")
	public boolean contemUsuarioComEssas(Credenciais credenciais);

	@Query("from Usuario where login = ?1")
	public List<Usuario> comNome(String nome);
		
}
