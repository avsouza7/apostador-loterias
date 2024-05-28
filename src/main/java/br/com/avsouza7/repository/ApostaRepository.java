package br.com.avsouza7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avsouza7.model.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {

	// @Query("SELECT a FROM Apostas a WHERE a.nuConcurso = :nuConcurso and a.usuario.email = :email ")
	// List<Aposta> getApostas(@Param("email") String email, @Param("nuConcurso") Long nuConcurso);

}
