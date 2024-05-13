package br.com.avsouza7.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apostas")
public class Aposta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAposta")
	private Long idAposta;
	@Column(name = "idLoteria", length = 50, nullable = false)
	@NotNull(message = "Loteria é obrigatório")
	private Long idLoteria;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id")
	private Usuario usuario;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAposta")
	private List<Dezena> dezenas = new ArrayList<>();

	public Long getIdAposta() {
		return idAposta;
	}

	public void setIdAposta(Long idAposta) {
		this.idAposta = idAposta;
	}

	public List<Dezena> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Dezena> dezenas) {
		this.dezenas = dezenas;
	}

	public Long getIdLoteria() {
		return idLoteria;
	}

	public void setIdLoteria(Long idLoteria) {
		this.idLoteria = idLoteria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Aposta [idAposta=" + idAposta + ", idLoteria=" + idLoteria + ", usuario=" + usuario + ", dezenas=" + dezenas + "]";
	}

}
