package br.com.avsouza7.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.avsouza7.json.CustomDezenaDeserializer;
import br.com.avsouza7.json.CustomDezenaSerializer;

public class Dezena {

	@JsonSetter
	@JsonSerialize(using = CustomDezenaSerializer.class)
	@JsonDeserialize(using = CustomDezenaDeserializer.class)
	private Long idDezena;
	private boolean foiSorteada;

	public Dezena() {
	}

	public Dezena(Long idDezena) {
		this.idDezena = idDezena;
	}

	public Dezena(String idDezena) {
		this.idDezena = Long.valueOf(idDezena);
	}

	public Long getIdDezena() {
		return idDezena;
	}

	public void setIdDezena(Long idDezena) {
		this.idDezena = idDezena;
	}

	public boolean isFoiSorteada() {
		return foiSorteada;
	}

	public void setFoiSorteada(boolean foiSorteada) {
		this.foiSorteada = foiSorteada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDezena == null) ? 0 : idDezena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Dezena other = (Dezena) obj;
		return this.getIdDezena().equals(other.getIdDezena());
	}

	@Override
	public String toString() {
		return "Dezena [idDezena=" + idDezena + ", foiSorteada=" + foiSorteada + "]";
	}
}
