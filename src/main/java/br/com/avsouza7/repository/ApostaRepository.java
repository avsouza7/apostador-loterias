package br.com.avsouza7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.avsouza7.model.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {

  // @Query("SELECT a FROM Apostas a WHERE a.nuConcurso=:idConcurso and a.idGrupo=:idGrupo and
  // a.idLoteria=:idLoteria")
  // List<Aposta> getApostas(@Param("idLoteria") Long idLoteria, @Param("idGrupo") Long idGrupo,
  // @Param("idConcurso") Long idConcurso);

}
