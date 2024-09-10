package br.com.avsouza7.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agrupador {
	private Long idConcurso;
	private Map<Long, List<Aposta>> mapa = new HashMap<>();

	public Long getIdConcurso() {
		return idConcurso;
	}

	public Map<Long, List<Aposta>> getApostas() {
		return mapa;
	}

	public void addApostas(Long idConcurso, List<Aposta> apostas) {
		mapa.put(idConcurso, apostas);
	}
}
