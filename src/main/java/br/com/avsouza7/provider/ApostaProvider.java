package br.com.avsouza7.provider;

import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.avsouza7.enuns.GrupoEnum;
import br.com.avsouza7.enuns.LoteriaEnum;
import br.com.avsouza7.exceptions.CustomException;
import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Agrupador;
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
			return getApostas(filter, new HashMap<>());
		}
		if (LoteriaEnum.QUINA.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			return getApostas(filter, new HashMap<>());
		}
		throw new CustomException("Não foi implementado uma aposta para o Enum.");
	}

	private List<Aposta> getApostas(ResultadoFilter filter, Map<GrupoEnum, Agrupador> mapaDeApostas) {
		Optional<Agrupador> optionalAgrupador = Optional.ofNullable(mapaDeApostas.get(filter.getGrupoEnum()));
		if (optionalAgrupador.isPresent()) {
			Optional<List<Aposta>> apostas = Optional.ofNullable(optionalAgrupador.get().getApostas().get(filter.getIdConcurso()));
			if (apostas.isPresent()) {
				return apostas.get();
			}
		}
		throw new CustomException(String.format("Nenhuma aposta encontrada para o grupo %s concurso %s da loteria %s.", filter.getGrupoEnum().getNmGrupo(), filter.getIdConcurso(), LoteriaEnum.getById(filter.getIdLoteria()).getNome()));
	}

	private Map<GrupoEnum, Agrupador> mapaDeApostasLotoFacil() {
		Map<GrupoEnum, Agrupador> apostas = new EnumMap<>(GrupoEnum.class);
		apostas.put(GrupoEnum.SOZINHO, sozinho());
		apostas.put(GrupoEnum.PAPO_DE_CUNHADO, papoDeCunhado());
		return apostas;
	}

	private Agrupador sozinho() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(3079l, List.of(umaApostaLotofacil(DateUtil.convertBr("15/04/2024"), 1, 2, 4, 6, 7, 9, 11, 13, 14, 15, 17, 18, 19, 22, 23)));
		agrupador.addApostas(3096l, List.of(umaApostaLotofacil(DateUtil.convertBr("06/05/2024"), 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25)));
		agrupador.addApostas(3159l, List.of(umaApostaLotofacil(DateUtil.convertBr("19/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3160l, List.of(umaApostaLotofacil(DateUtil.convertBr("20/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3161l, List.of(umaApostaLotofacil(DateUtil.convertBr("22/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3162l, List.of(umaApostaLotofacil(DateUtil.convertBr("23/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3163l, List.of(umaApostaLotofacil(DateUtil.convertBr("24/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3164l, List.of(umaApostaLotofacil(DateUtil.convertBr("25/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3165l, List.of(umaApostaLotofacil(DateUtil.convertBr("26/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3166l, List.of(umaApostaLotofacil(DateUtil.convertBr("27/07/2024"), 1, 2, 6, 8, 9, 11, 12, 14, 16, 17, 19, 21, 22, 23, 25)));
		agrupador.addApostas(3190l, List.of(umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 7, 8, 10, 12, 13, 18, 19, 21, 22, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 5, 6, 8, 10, 11, 13, 14, 17, 18, 19, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 7, 8, 9, 10, 11, 15, 17, 18, 20, 21, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 7, 8, 11, 13, 14, 15, 16, 18, 19, 21, 22, 23)));
		return agrupador;
	}

	private Agrupador papoDeCunhado() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(3190l, List.of(umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 6, 8, 9, 10, 15, 16, 17, 18, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 7, 8, 9, 12, 13, 14, 16, 17, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 9, 10, 11, 12, 13, 14, 16, 18, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 18, 20, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 5, 6, 8, 9, 10, 13, 14, 16, 19, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 8, 10, 12, 18, 19, 20, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 4, 5, 6, 8, 10, 14, 15, 16, 17, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 11, 13, 15, 16, 17, 18, 19, 20, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 6, 8, 10, 12, 13, 14, 16, 17, 18, 19, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 6, 7, 8, 10, 13, 14, 17, 18, 20, 21, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 9, 11, 12, 13, 17, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 4, 7, 8, 9, 10, 11, 12, 15, 16, 17, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 6, 93, 10, 11, 12, 13, 15, 17, 19, 20, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 6, 7, 8, 9, 10, 13, 16, 17, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 7, 8, 9, 12, 15, 16, 17, 19, 20, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 5, 7, 9, 10, 12, 13, 16, 17, 19, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 4, 5, 6, 78, 10, 11, 12, 13, 14, 15, 17, 21), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 5, 6, 9, 12, 13, 14, 15, 16, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 6, 10, 12, 14, 15, 316, 19, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 7, 8, 9, 10, 11, 13, 14, 15, 17, 19, 20, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 6, 7, 9, 10, 11, 13, 14, 16, 17, 18, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 7, 10, 14, 15, 16, 18, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 7, 8, 9, 10, 14, 16, 18, 19, 20, 21, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 8, 10, 11, 12, 14, 15, 17, 19, 20, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 6, 7, 9, 10, 14, 15, 16, 17, 18, 20, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 5, 6, 9, 10, 12, 15, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 6, 9, 11, 12, 13, 15, 17, 18, 19, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 6, 8, 13, 14, 15, 18, 19, 20, 21, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 7, 8, 11, 12, 14, 16, 17, 18, 19, 20, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 5, 6, 7, 8, 10, 12, 14, 15, 17, 18, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 5, 6, 7, 8, 11, 13, 18, 20, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 20, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 6, 7, 9, 11, 12, 13, 14, 19, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 21, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 4, 5, 6, 8, 10, 14, 15, 19, 20, 21, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 5, 6, 7, 9, 13, 15, 17, 18, 19, 20, 21, 22), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 6, 7, 8, 9, 10, 13, 18, 19, 20, 21, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 6, 8, 9, 11, 12, 13, 14, 15, 16, 17, 20, 22, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 6, 8, 10, 11, 12, 13, 15, 18, 20, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 6, 7, 8, 9, 10, 13, 15, 17, 19, 20, 21, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 11, 12, 14, 16, 18, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 5, 7, 9, 10, 12, 13, 15, 16, 17, 18, 19, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 6, 7, 12, 13, 14, 15, 16, 17, 18, 21), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 5, 7, 9, 10, 11, 12, 14, 15, 20, 22, 2, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 7, 9, 11, 13, 16, 17, 18, 19, 22, 24)));
		return agrupador;
	}

	private Aposta umaApostaLotofacil(Date dtSorteio, int... dezenas) {
		return umaAposta(LoteriaEnum.LOTOFACIL, dtSorteio, dezenas);
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
