package br.com.avsouza7.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.avsouza7.model.Apostador;

public interface ApostadorRepository extends JpaRepository<Apostador, Long> {

  @Query("SELECT a FROM Apostador a WHERE a.idConcurso=:idConcurso and a.idGrupo=:idGrupo and a.idLoteria=:idLoteria")
  List<Apostador> getApostadores(@Param("idLoteria") Long idLoteria, @Param("idGrupo") Long idGrupo,
      @Param("idConcurso") Long idConcurso);

}
