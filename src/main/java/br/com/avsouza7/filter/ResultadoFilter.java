package br.com.avsouza7.filter;

import br.com.avsouza7.enuns.LoteriaEnum;

public class ResultadoFilter {

	private Long idConcurso;
	private Long idLoteria;

	public Long getIdConcurso() {
		return idConcurso;
	}

	public void setIdConcurso(Long idConcurso) {
		this.idConcurso = idConcurso;
	}

	public Long getIdLoteria() {
		return idLoteria;
	}

	public void setIdLoteria(Long idLoteria) {
		this.idLoteria = idLoteria;
	}

	public LoteriaEnum getLoteriaEnum() {
		return LoteriaEnum.getById(idLoteria);
	}

}
