package br.com.avsouza7.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.avsouza7.enuns.LoteriaEnum;
import br.com.avsouza7.exceptions.CustomException;
import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Aposta;
import br.com.avsouza7.model.Dezena;

public class ApostaProvider {

	private static final Long ID_APOSTA = 1l;

	public List<Aposta> getApostas(ResultadoFilter filter) {

		if (LoteriaEnum.LOTOFACIL.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			return getApostas(filter, mapaDeApostasLotoFacil());
		}
		if (LoteriaEnum.MEGASENA.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			return getApostas(filter, mapaDeApostasMegasena());
		}
		throw new CustomException("Não foi implementado uma aposta para o Enum.");
	}

	private List<Aposta> getApostas(ResultadoFilter filter, Map<Long, List<Aposta>> mapaDeApostas) {
		Optional<List<Aposta>> apostas = Optional.ofNullable(mapaDeApostas.get(filter.getIdConcurso()));
		if (apostas.isPresent()) {
			return apostas.get();
		}
		throw new CustomException("Nenhuma aposta encontrada para o concurso.");
	}

	private Map<Long, List<Aposta>> mapaDeApostasLotoFacil() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		apostas.put(3079l, List.of(umaAposta(1, 2, 4, 6, 7, 9, 11, 13, 14, 15, 17, 18, 19, 22, 23)));
		apostas.put(3096l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3097l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3098l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3099l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3100l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3101l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3102l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3103l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3104l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3105l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3106l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3107l, List.of(umaAposta(1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		apostas.put(3108l, List.of(umaAposta(1, 4, 5, 8, 9, 11, 12, 13, 14, 15, 20, 21, 23, 24, 25)));
		apostas.put(3110l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3111l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3112l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3113l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3114l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3115l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3116l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3117l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3118l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3119l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3120l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		apostas.put(3121l, List.of(umaAposta(3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));

		return apostas;
	}

	private Map<Long, List<Aposta>> mapaDeApostasMegasena() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		apostas.put(0l, List.of(umaAposta()));
		return apostas;
	}

	private Aposta umaAposta(int... valores) {
		Aposta aposta = new Aposta();
		aposta.setIdAposta(ID_APOSTA);
		for (int i = 0; i < valores.length; i++) {
			aposta.getDezenas().add(umaDezena(Long.valueOf(valores[i])));
		}
		return aposta;
	}

	private Dezena umaDezena(Long nuDezena) {
		Dezena dezena = new Dezena();
		dezena.setNuDezena(nuDezena);
		return dezena;
	}
}
