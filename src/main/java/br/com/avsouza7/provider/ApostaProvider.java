package br.com.avsouza7.provider;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.avsouza7.enuns.LoteriaEnum;
import br.com.avsouza7.exceptions.CustomException;
import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Aposta;
import br.com.avsouza7.model.Dezena;
import br.com.avsouza7.util.DateUtil;

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
		apostas.put(3079l, List.of(umaApostaLotofacil(DateUtil.convertBr("15/04/2024"), 1, 2, 4, 6, 7, 9, 11, 13, 14, 15, 17, 18, 19, 22, 23)));
		apostas.put(3096l, List.of(umaApostaLotofacil(DateUtil.convertBr("06/05/2024"), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3097l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3098l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3099l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3100l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3101l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3102l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3103l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3104l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3105l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3106l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3107l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		// apostas.put(3108l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 4, 5, 8, 9, 11, 12, 13, 14, 15, 20, 21, 23, 24, 25)));
		// apostas.put(3110l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3111l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3112l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3113l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3114l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3115l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3116l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3117l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3118l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3119l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3120l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3121l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 5, 6, 7, 8, 10, 15, 17, 18, 19, 20, 21, 23, 24)));
		// apostas.put(3122l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3123l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3124l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3125l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3126l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3127l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 3, 4, 6, 8, 9, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3140l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 3, 5, 6, 10, 13, 14, 16, 17, 19, 20, 22, 24, 5), umaApostaLotofacil(DateUtil.convertBr(""), 2, 3, 4, 6, 7, 8, 12, 13, 18, 19, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr(""), 2, 3, 4, 5, 6, 10, 11, 13, 14, 15, 17, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 3, 4, 6, 8, 10, 11, 13, 15, 18, 20, 23, 24, 25)));
		// apostas.put(3145l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3146l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3147l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3148l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3149l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3150l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3151l, List.of(umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3152l, List.of(umaApostaLotofacil(DateUtil.convertBr("11/07/2024"), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3153l, List.of(umaApostaLotofacil(DateUtil.convertBr("12/07/2024"), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3154l, List.of(umaApostaLotofacil(DateUtil.convertBr("13/07/2024"), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3155l, List.of(umaApostaLotofacil(DateUtil.convertBr("15/07/2024"), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		apostas.put(3156l, List.of(umaApostaLotofacil(DateUtil.convertBr("16/07/2024"), 1, 3, 4, 6, 8, 10, 13, 14, 15, 16, 18, 20, 21, 24, 25)));
		// apostas.put(3158l, List.of(umaApostaLotofacil(DateUtil.convertBr("18/07/2024"), 1, 4, 5, 7, 8, 11, 12, 13, 14, 15, 16, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr(""), 1, 3, 4, 5, 6, 8, 11, 15, 17, 18, 19, 20, 21, 22, 23), umaApostaLotofacil(DateUtil.convertBr(""), 2, 3, 4, 5, 7, 8, 11, 15, 16, 18, 19, 20, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr(""), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 24)));
		apostas.put(3159l, List.of(umaApostaLotofacil(DateUtil.convertBr("19/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3160l, List.of(umaApostaLotofacil(DateUtil.convertBr("20/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3161l, List.of(umaApostaLotofacil(DateUtil.convertBr("22/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3162l, List.of(umaApostaLotofacil(DateUtil.convertBr("23/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3163l, List.of(umaApostaLotofacil(DateUtil.convertBr("24/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3164l, List.of(umaApostaLotofacil(DateUtil.convertBr("25/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3165l, List.of(umaApostaLotofacil(DateUtil.convertBr("26/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		apostas.put(3166l, List.of(umaApostaLotofacil(DateUtil.convertBr("27/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		return apostas;
	}

	private Map<Long, List<Aposta>> mapaDeApostasMegasena() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		// apostas.put(2743l, List.of(umaApostaMesaSena(DateUtil.convertBr(""), 17, 18, 21, 31, 42, 57), umaApostaMesaSena(DateUtil.convertBr(""), 6, 31, 36, 53, 57, 58), umaApostaMesaSena(DateUtil.convertBr(""), 2, 23, 44, 45, 53, 57), umaApostaMesaSena(DateUtil.convertBr(""), 8, 12, 15, 16, 28, 35), umaApostaMesaSena(DateUtil.convertBr(""), 8, 36, 42, 49, 50, 57), umaApostaMesaSena(DateUtil.convertBr(""), 1, 5, 33, 47, 50, 51), umaApostaMesaSena(DateUtil.convertBr(""), 9, 10, 25, 41, 43, 59), umaApostaMesaSena(DateUtil.convertBr(""), 8, 23, 25, 33, 34, 48), umaApostaMesaSena(DateUtil.convertBr(""), 2, 24, 28, 46, 50, 56), umaApostaMesaSena(DateUtil.convertBr(""), 3, 9, 15, 22, 34, 50), umaApostaMesaSena(DateUtil.convertBr(""), 3, 16, 19, 34, 56, 60), umaApostaMesaSena(DateUtil.convertBr(""), 5, 13, 28, 32, 44, 50), umaApostaMesaSena(DateUtil.convertBr(""), 5, 9, 26, 32, 49, 53), umaApostaMesaSena(DateUtil.convertBr(""), 16, 24, 33, 41, 56, 60), umaApostaMesaSena(DateUtil.convertBr(""), 1, 15, 20, 28, 53, 58)));

		// grupo dos cunhados, Silvio quem fez
		// apostas.put(2745l, List.of(umaAposta(4, 5, 18, 25, 35, 47), umaAposta(16, 17, 23, 39, 42, 60), umaAposta(3, 32, 43, 52, 55, 57), umaAposta(1, 2, 8, 31, 34, 35), umaAposta(7, 17, 24, 44, 56, 59), umaAposta(3, 11, 16, 40, 42, 46), umaAposta(3, 16, 20, 25, 36, 38), umaAposta(4, 10, 15, 22, 24, 59), umaAposta(3, 43, 44, 46, 50, 55), umaAposta(32, 35, 36, 37, 54, 57), umaAposta(7, 9, 11, 21, 47, 60), umaAposta(9, 22, 26, 28, 44, 54), umaAposta(5, 14, 23, 47, 52, 60), umaAposta(10, 11, 33, 47, 51, 55), umaAposta(14, 15, 25, 36, 47, 58)));

		// grupo do trabalho
		// apostas.put(2745l, List.of(umaAposta(3, 9, 22, 33, 51, 52), umaAposta(5, 28, 32, 43, 46, 47, 54), umaAposta(2, 3, 7, 17, 28, 42, 55, 59)));

		// grupo do diretoria
		apostas.put(2745l, List.of(umaApostaMesaSena(DateUtil.convertBr("04/07/2024"), 8, 13, 18, 19, 21, 25, 39), umaApostaMesaSena(DateUtil.convertBr("04/07/2024"), 2, 16, 30, 35, 57, 59, 60), umaApostaMesaSena(DateUtil.convertBr("04/07/2024"), 2, 8, 29, 36, 37, 54, 56)));
		apostas.put(2752l, List.of(umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 2, 14, 18, 23, 27, 25), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 11, 12, 21, 28, 29, 53), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 18, 26, 36, 47, 50, 54), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 2, 20, 21, 29, 54, 60), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 2, 15, 16, 36, 55, 59), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 13, 30, 32, 48, 50, 58), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 1, 4, 5, 12, 29, 45), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 5, 15, 19, 46, 56, 57), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 6, 21, 24, 31, 35, 52), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 3, 18, 25, 34, 50, 51), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 11, 22, 27, 33, 44, 55), umaApostaMesaSena(DateUtil.convertBr("23/07/2024"), 7, 22, 25, 40, 53, 58)));
		apostas.put(2753l, List.of(umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 2, 9, 16, 17, 26, 38), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 3, 18, 25, 34, 50, 51), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 7, 22, 25, 40, 53, 58), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 2, 12, 14, 27, 33, 52), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 6, 27, 37, 38, 42, 48), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 2, 9, 13, 18, 23, 55), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 7, 9, 18, 23, 28, 58), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 22, 36, 47, 50, 57, 60), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 2, 14, 40, 42, 57, 59), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 21, 30, 33, 40, 43, 44), umaApostaMesaSena(DateUtil.convertBr("25/07/2024"), 16, 22, 44, 47, 53, 60)));
		return apostas;
	}

	private Map<Long, List<Aposta>> mapaDeApostasQuina() {
		Map<Long, List<Aposta>> apostas = new HashMap<>();
		// apostas.put(6459l, List.of(umaApostaQuina(DateUtil.convertBr(""), 4, 35, 46, 58, 76), umaApostaQuina(DateUtil.convertBr(""), 14, 25, 48, 62, 66)));
		// apostas.put(6460l, List.of(umaApostaQuina(DateUtil.convertBr(""), 4, 35, 46, 58, 76), umaApostaQuina(DateUtil.convertBr(""), 14, 25, 48, 62, 66)));
		// apostas.put(6461l, List.of(umaApostaQuina(DateUtil.convertBr(""), 4, 35, 46, 58, 76), umaApostaQuina(DateUtil.convertBr(""), 14, 25, 48, 62, 66)));
		return apostas;
	}

	private Aposta umaApostaLotofacil(Date dtSorteio, int... dezenas) {
		return umaAposta(LoteriaEnum.LOTOFACIL, dtSorteio, dezenas);
	}

	private Aposta umaApostaMesaSena(Date dtSorteio, int... dezenas) {
		return umaAposta(LoteriaEnum.MEGASENA, dtSorteio, dezenas);
	}

	private Aposta umaApostaQuina(Date dtSorteio, int... dezenas) {
		return umaAposta(LoteriaEnum.QUINA, dtSorteio, dezenas);
	}

	private Aposta umaAposta(LoteriaEnum loteria, Date dtSorteio, int... dezenas) {
		Aposta aposta = new Aposta();
		aposta.setIdAposta(ID_APOSTA);
		aposta.setIdLoteria(loteria.getIdLoteria());
		aposta.setDtSorteio(dtSorteio);
		for (int i = 0; i < dezenas.length; i++) {
			aposta.getDezenas().add(umaDezena(Long.valueOf(dezenas[i])));
		}
		return aposta;
	}

	private Dezena umaDezena(Long nuDezena) {
		Dezena dezena = new Dezena();
		dezena.setNuDezena(nuDezena);
		return dezena;
	}
}
