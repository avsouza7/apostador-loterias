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
		if (LoteriaEnum.QUINA.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			return getApostas(filter, mapaDeApostasQuina());
		}
		throw new CustomException("Não foi implementado uma aposta para o Enum.");
	}

	private List<Aposta> getApostas(ResultadoFilter filter, Map<Long, List<Aposta>> mapaDeApostas) {
		Optional<List<Aposta>> apostas = Optional.ofNullable(mapaDeApostas.get(filter.getIdConcurso()));
		if (apostas.isPresent()) {
			return apostas.get();
		}
		throw new CustomException(String.format("Nenhuma aposta encontrada para o concurso %s da loteria %s.", filter.getIdConcurso(), LoteriaEnum.getById(filter.getIdLoteria()).getNome()));
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
		apostas.put(3122l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3123l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3124l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3125l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3126l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3127l, List.of(umaAposta(3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3140l, List.of(umaAposta(1, 2, 3, 5, 6, 10, 13, 14, 16, 17, 19, 20, 22, 24, 5), umaAposta(2, 3, 4, 6, 7, 8, 12, 13, 18, 19, 20, 22, 23, 24, 25), umaAposta(2, 3, 4, 5, 6, 10, 11, 13, 14, 15, 17, 19, 21, 22, 25), umaAposta(1, 2, 3, 4, 6, 8, 10, 11, 13, 15, 18, 20, 23, 24, 25)));
		apostas.put(3145l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3146l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3147l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3148l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3149l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3150l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3151l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3152l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3153l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3154l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3155l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3156l, List.of(umaAposta(1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		return apostas;
	}

	private Map<Long, List<Aposta>> mapaDeApostasMegasena() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		apostas.put(2743l, List.of(umaAposta(17, 18, 21, 31, 42, 57), umaAposta(6, 31, 36, 53, 57, 58), umaAposta(2, 23, 44, 45, 53, 57), umaAposta(8, 12, 15, 16, 28, 35), umaAposta(8, 36, 42, 49, 50, 57), umaAposta(1, 5, 33, 47, 50, 51), umaAposta(9, 10, 25, 41, 43, 59), umaAposta(8, 23, 25, 33, 34, 48), umaAposta(2, 24, 28, 46, 50, 56), umaAposta(3, 9, 15, 22, 34, 50), umaAposta(3, 16, 19, 34, 56, 60), umaAposta(5, 13, 28, 32, 44, 50), umaAposta(5, 9, 26, 32, 49, 53), umaAposta(16, 24, 33, 41, 56, 60), umaAposta(1, 15, 20, 28, 53, 58)));

		// grupo dos cunhados, Silvio quem fez
		// apostas.put(2745l, List.of(umaAposta(4, 5, 18, 25, 35, 47), umaAposta(16, 17, 23, 39, 42, 60), umaAposta(3, 32, 43, 52, 55, 57), umaAposta(1, 2, 8, 31, 34, 35), umaAposta(7, 17, 24, 44, 56, 59), umaAposta(3, 11, 16, 40, 42, 46), umaAposta(3, 16, 20, 25, 36, 38), umaAposta(4, 10, 15, 22, 24, 59), umaAposta(3, 43, 44, 46, 50, 55), umaAposta(32, 35, 36, 37, 54, 57), umaAposta(7, 9, 11, 21, 47, 60), umaAposta(9, 22, 26, 28, 44, 54), umaAposta(5, 14, 23, 47, 52, 60), umaAposta(10, 11, 33, 47, 51, 55), umaAposta(14, 15, 25, 36, 47, 58)));

		// grupo do trabalho
		// apostas.put(2745l, List.of(umaAposta(3, 9, 22, 33, 51, 52), umaAposta(5, 28, 32, 43, 46, 47, 54), umaAposta(2, 3, 7, 17, 28, 42, 55, 59)));

		// grupo do diretoria
		apostas.put(2745l, List.of(umaAposta(8, 13, 18, 19, 21, 25, 39), umaAposta(2, 16, 30, 35, 57, 59, 60), umaAposta(2, 8, 29, 36, 37, 54, 56)));
		return apostas;
	}

	private Map<Long, List<Aposta>> mapaDeApostasQuina() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		apostas.put(6459l, List.of(umaAposta(4, 35, 46, 58, 76), umaAposta(14, 25, 48, 62, 66)));
		apostas.put(6460l, List.of(umaAposta(4, 35, 46, 58, 76), umaAposta(14, 25, 48, 62, 66)));
		apostas.put(6461l, List.of(umaAposta(4, 35, 46, 58, 76), umaAposta(14, 25, 48, 62, 66)));
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
