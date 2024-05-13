package br.com.avsouza7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.avsouza7.json.CustomDezenaDeserializer;
import br.com.avsouza7.json.CustomDezenaSerializer;

@Entity
@Table(name = "dezena")
public class Dezena {

	@JsonSetter
	@JsonSerialize(using = CustomDezenaSerializer.class)
	@JsonDeserialize(using = CustomDezenaDeserializer.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDezena")
	private Long idDezena;
	private Long nuDezena;

	private boolean foiSorteada;

	public Dezena() {
	}

	public Dezena(Long nuDezena) {
		this.nuDezena = nuDezena;
	}

	public Dezena(String nuDezena) {
		this.nuDezena = Long.valueOf(nuDezena);
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
		return this.getNuDezena().equals(other.getNuDezena());
	}

	public Long getNuDezena() {
		return nuDezena;
	}

	public void setNuDezena(Long nuDezena) {
		this.nuDezena = nuDezena;
	}

	@Override
	public String toString() {
		return "Dezena [idDezena=" + idDezena + ", nuDezena=" + nuDezena + ", foiSorteada=" + foiSorteada + "]";
	}
}
