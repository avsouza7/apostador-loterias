package br.com.avsouza7.enuns;

import java.util.HashMap;
import java.util.Map;

public enum LoteriaEnum {
	MEGASENA(1l, "Mega-Sena") {
		@Override
		public Map<Integer, Integer> faixas() {
			Map<Integer, Integer> faixas = new HashMap<>();
			faixas.put(6, 1);
			faixas.put(5, 2);
			faixas.put(4, 3);
			return faixas;
		}
	},
	LOTOFACIL(2l, "Lotofácil") {
		@Override
		public Map<Integer, Integer> faixas() {
			Map<Integer, Integer> faixas = new HashMap<>();
			faixas.put(15, 1);
			faixas.put(14, 2);
			faixas.put(13, 3);
			faixas.put(12, 4);
			faixas.put(11, 5);
			return faixas;
		}
	},
	QUINA(3l, "Quina") {
		@Override
		public Map<Integer, Integer> faixas() {
			Map<Integer, Integer> faixas = new HashMap<>();
			faixas.put(5, 1);
			faixas.put(4, 2);
			faixas.put(3, 3);
			faixas.put(2, 4);
			return faixas;
		}
	};

	private final Long idLoteria;
	private final String nome;

	public abstract Map<Integer, Integer> faixas();

	private LoteriaEnum(Long idLoteria, String nome) {
		this.idLoteria = idLoteria;
		this.nome = nome;
	}

	public Long getIdLoteria() {
		return idLoteria;
	}

	public String getNome() {
		return nome;
	}

	public static LoteriaEnum getById(Long idLoteria) {
		for (LoteriaEnum e : values()) {
			if (e.idLoteria.equals(idLoteria)) {
				return e;
			}
		}
		throw new IllegalArgumentException(String.format("Não existe uma loteira com o id %s", idLoteria));
	}

}
