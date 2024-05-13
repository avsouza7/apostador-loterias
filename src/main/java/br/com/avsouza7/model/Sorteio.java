package br.com.avsouza7.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.avsouza7.json.CustomDateDeserializer;
import br.com.avsouza7.json.CustomDateSerializer;

public class Sorteio {
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonSetter("dataApuracao")
	private Date dtSorteio;
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonSetter("dataProximoConcurso")
	private Date dtProximoSorteio;
	private Long idLoteria;
	private Long idConcurso;
	@JsonSetter("listaDezenas")
	private List<Dezena> dezenas = new ArrayList<>();

	@JsonSetter("listaRateioPremio")
	private List<Premio> premios = new ArrayList<>();

	public Date getDtSorteio() {
		return dtSorteio;
	}

	public void setDtSorteio(Date dtSorteio) {
		this.dtSorteio = dtSorteio;
	}

	public Long getIdLoteria() {
		return idLoteria;
	}

	public void setIdLoteria(Long idLoteria) {
		this.idLoteria = idLoteria;
	}

	public List<Dezena> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Dezena> dezenas) {
		this.dezenas = dezenas;
	}

	public Long getIdConcurso() {
		return idConcurso;
	}

	public void setIdConcurso(Long idConcurso) {
		this.idConcurso = idConcurso;
	}

	public List<Premio> getPremios() {
		return premios;
	}

	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}

	public Date getDtProximoSorteio() {
		return dtProximoSorteio;
	}

	public void setDtProximoSorteio(Date dtProximoSorteio) {
		this.dtProximoSorteio = dtProximoSorteio;
	}

}
