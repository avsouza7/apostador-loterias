package br.com.avsouza7.provider;

import java.util.Date;
import java.util.EnumMap;
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
			return getApostas(filter, mapaDeApostasMegaSena());
		}
		if (LoteriaEnum.QUINA.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			return getApostas(filter, mapaDeApostasQuina());
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
		apostas.put(GrupoEnum.SOZINHO, sozinhoLotoFacil());
		apostas.put(GrupoEnum.PAPO_DE_CUNHADO, papoDeCunhadoLotofacil());
		return apostas;
	}

	private Map<GrupoEnum, Agrupador> mapaDeApostasMegaSena() {
		Map<GrupoEnum, Agrupador> apostas = new EnumMap<>(GrupoEnum.class);
		apostas.put(GrupoEnum.PAPO_DE_CUNHADO, papoDeCunhadoMegaSena());
		apostas.put(GrupoEnum.SOZINHO, sozinhoMegaSena());
		return apostas;
	}

	private Map<GrupoEnum, Agrupador> mapaDeApostasQuina() {
		Map<GrupoEnum, Agrupador> apostas = new EnumMap<>(GrupoEnum.class);
		apostas.put(GrupoEnum.PAPO_DE_CUNHADO, papoDeCunhadoQuina());
		return apostas;
	}

	private Agrupador sozinhoLotoFacil() {
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
		agrupador.addApostas(3191l, List.of(umaApostaLotofacil(DateUtil.convertBr("10/09/2024"), 2, 3, 4, 5, 6, 9, 10, 12, 13, 14, 16, 18, 20, 21, 24), umaApostaLotofacil(DateUtil.convertBr("10/09/2024"), 3, 8, 9, 11, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24)));
		agrupador.addApostas(3192l, List.of(umaApostaLotofacil(DateUtil.convertBr("11/09/2024"), 2, 3, 4, 5, 6, 9, 10, 12, 13, 14, 16, 18, 20, 21, 24), umaApostaLotofacil(DateUtil.convertBr("11/09/2024"), 3, 8, 9, 11, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24)));
		agrupador.addApostas(3193l, List.of(umaApostaLotofacil(DateUtil.convertBr("12/09/2024"), 2, 3, 4, 5, 6, 9, 10, 12, 13, 14, 16, 18, 20, 21, 24), umaApostaLotofacil(DateUtil.convertBr("12/09/2024"), 3, 8, 9, 11, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24)));
		agrupador.addApostas(3194l, List.of(umaApostaLotofacil(DateUtil.convertBr("13/09/2024"), 2, 3, 4, 5, 6, 9, 10, 12, 13, 14, 16, 18, 20, 21, 24), umaApostaLotofacil(DateUtil.convertBr("13/09/2024"), 3, 8, 9, 11, 12, 13, 14, 16, 17, 18, 20, 21, 22, 23, 24)));
		agrupador.addApostas(3196l, List.of(umaApostaLotofacil(DateUtil.convertBr("16/09/2024"), 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 15, 18, 20, 21, 23), umaApostaLotofacil(DateUtil.convertBr("16/09/2024"), 2, 5, 9, 10, 11, 12, 13, 14, 16, 17, 18, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("16/09/2024"), 1, 3, 5, 6, 8, 10, 11, 12, 14, 15, 18, 19, 20, 22, 25), umaApostaLotofacil(DateUtil.convertBr("16/09/2024"), 4, 5, 7, 8, 9, 11, 15, 17, 18, 19, 20, 21, 22, 23, 24)));
		agrupador.addApostas(3197l, List.of(umaApostaLotofacil(DateUtil.convertBr("17/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3198l, List.of(umaApostaLotofacil(DateUtil.convertBr("18/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3199l, List.of(umaApostaLotofacil(DateUtil.convertBr("19/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3200l, List.of(umaApostaLotofacil(DateUtil.convertBr("20/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3201l, List.of(umaApostaLotofacil(DateUtil.convertBr("21/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3202l, List.of(umaApostaLotofacil(DateUtil.convertBr("23/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3203l, List.of(umaApostaLotofacil(DateUtil.convertBr("24/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3204l, List.of(umaApostaLotofacil(DateUtil.convertBr("25/09/2024"), 1, 4, 5, 6, 7, 10, 11, 14, 15, 16, 17, 18, 19, 20, 23)));
		agrupador.addApostas(3205l, List.of(umaApostaLotofacil(DateUtil.convertBr("26/09/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("26/09/2024"), 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("26/09/2024"), 2, 6, 7, 8, 9, 11, 15, 16, 17, 18, 19, 20, 21, 23, 24)));
		agrupador.addApostas(3206l, List.of(umaApostaLotofacil(DateUtil.convertBr("27/09/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("27/09/2024"), 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("27/09/2024"), 2, 6, 7, 8, 9, 11, 15, 16, 17, 18, 19, 20, 21, 23, 24)));
		agrupador.addApostas(3207l, List.of(umaApostaLotofacil(DateUtil.convertBr("28/09/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("28/09/2024"), 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("28/09/2024"), 2, 6, 7, 8, 9, 11, 15, 16, 17, 18, 19, 20, 21, 23, 24)));
		agrupador.addApostas(3208l, List.of(umaApostaLotofacil(DateUtil.convertBr("30/09/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3209l, List.of(umaApostaLotofacil(DateUtil.convertBr("01/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3210l, List.of(umaApostaLotofacil(DateUtil.convertBr("02/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3211l, List.of(umaApostaLotofacil(DateUtil.convertBr("03/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3212l, List.of(umaApostaLotofacil(DateUtil.convertBr("04/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3213l, List.of(umaApostaLotofacil(DateUtil.convertBr("05/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3214l, List.of(umaApostaLotofacil(DateUtil.convertBr("07/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3215l, List.of(umaApostaLotofacil(DateUtil.convertBr("08/10/2024"), 1, 2, 3, 5, 7, 8, 10, 11, 13, 16, 17, 19, 21, 23, 24)));
		agrupador.addApostas(3216l, List.of(umaApostaLotofacil(DateUtil.convertBr("09/10/2024"), 1, 4, 5, 6, 7, 8, 13, 14, 15, 17, 19, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/10/2024"), 3, 4, 7, 8, 9, 10, 11, 15, 16, 18, 20, 21, 22, 24, 25)));
		agrupador.addApostas(3217l, List.of(umaApostaLotofacil(DateUtil.convertBr("10/10/2024"), 1, 4, 5, 6, 8, 9, 14, 16, 17, 18, 19, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("10/10/2024"), 3, 4, 5, 6, 8, 11, 13, 14, 15, 16, 18, 19, 21, 22, 23)));
		agrupador.addApostas(3218l, List.of(umaApostaLotofacil(DateUtil.convertBr("11/10/2024"), 3, 4, 5, 6, 8, 11, 13, 14, 15, 16, 18, 19, 21, 22, 23)));
		agrupador.addApostas(3219l, List.of(umaApostaLotofacil(DateUtil.convertBr("14/10/2024"), 3, 4, 5, 6, 8, 11, 13, 14, 15, 16, 18, 19, 21, 22, 23)));
		agrupador.addApostas(3221l, List.of(umaApostaLotofacil(DateUtil.convertBr("16/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("16/10/2024"), 1, 2, 4, 7, 8, 9, 10, 11, 12, 16, 19, 20, 22, 23, 25)));
		agrupador.addApostas(3222l, List.of(umaApostaLotofacil(DateUtil.convertBr("17/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("17/10/2024"), 1, 2, 4, 7, 8, 9, 10, 11, 12, 16, 19, 20, 22, 23, 25)));
		agrupador.addApostas(3223l, List.of(umaApostaLotofacil(DateUtil.convertBr("18/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("18/10/2024"), 1, 2, 4, 7, 8, 9, 10, 11, 12, 16, 19, 20, 22, 23, 25)));
		agrupador.addApostas(3224l, List.of(umaApostaLotofacil(DateUtil.convertBr("19/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3225l, List.of(umaApostaLotofacil(DateUtil.convertBr("21/10/2024"), 1, 2, 3, 8, 11, 12, 14, 15, 16, 17, 19, 20, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("21/10/2024"), 4, 5, 7, 8, 9, 10, 11, 12, 15, 17, 19, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("21/10/2024"), 1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 16, 17, 19, 24)));
		return agrupador;
	}

	private Agrupador papoDeCunhadoLotofacil() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(3190l, List.of(umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 6, 8, 9, 10, 13, 15, 16, 17, 18, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 7, 8, 9, 12, 13, 14, 16, 17, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 9, 10, 11, 12, 13, 14, 16, 18, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 18, 20, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 5, 6, 8, 9, 10, 13, 14, 16, 19, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 8, 10, 12, 18, 19, 20, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 4, 5, 6, 8, 10, 14, 15, 16, 17, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 11, 13, 15, 16, 17, 18, 19, 20, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 6, 8, 10, 12, 13, 14, 16, 17, 18, 19, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 6, 7, 8, 10, 13, 14, 17, 18, 20, 21, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 9, 11, 12, 13, 17, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 4, 7, 8, 9, 10, 11, 12, 15, 16, 17, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 6, 9, 10, 11, 12, 13, 15, 17, 19, 20, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 6, 7, 8, 9, 10, 13, 16, 17, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 7, 8, 9, 12, 15, 16, 17, 19, 20, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 5, 7, 9, 10, 12, 13, 16, 17, 19, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 21), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 5, 6, 9, 12, 13, 14, 15, 16, 20, 21, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 6, 10, 12, 14, 15, 316, 19, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 7, 8, 9, 10, 11, 13, 14, 15, 17, 19, 20, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 6, 7, 9, 10, 11, 13, 14, 16, 17, 18, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 7, 10, 14, 15, 16, 18, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 4, 7, 8, 9, 10, 14, 16, 18, 19, 20, 21, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 8, 10, 11, 12, 14, 15, 17, 19, 20, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 6, 7, 9, 10, 14, 15, 16, 17, 18, 20, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 5, 6, 9, 10, 12, 15, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 6, 9, 11, 12, 13, 15, 17, 18, 19, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 6, 8, 13, 14, 15, 18, 19, 20, 21, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 7, 8, 11, 12, 14, 16, 17, 18, 19, 20, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 5, 6, 7, 8, 10, 12, 14, 15, 17, 18, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 5, 6, 7, 8, 11, 13, 18, 20, 21, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 20, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 6, 7, 9, 11, 12, 13, 14, 19, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 7, 8, 10, 13, 14, 15, 16, 17, 21, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 4, 5, 6, 8, 10, 14, 15, 19, 20, 21, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 4, 5, 6, 7, 9, 13, 15, 17, 18, 19, 20, 21, 22), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 5, 6, 7, 8, 9, 10, 13, 18, 19, 20, 21, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 4, 6, 8, 9, 11, 12, 13, 14, 15, 16, 17, 20, 22, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 5, 6, 8, 10, 11, 12, 13, 15, 18, 20, 23, 24), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 2, 3, 6, 7, 8, 9, 10, 13, 15, 17, 19, 20, 21, 22, 23), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 7, 8, 9, 11, 12, 14, 16, 18, 20, 22, 24, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 3, 5, 7, 9, 10, 12, 13, 15, 16, 17, 18, 19, 21, 23, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 6, 7, 12, 13, 14, 15, 16, 17, 18, 21), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 3, 4, 5, 7, 9, 10, 11, 12, 14, 15, 20, 22, 2, 25), umaApostaLotofacil(DateUtil.convertBr("09/09/2024"), 1, 2, 3, 4, 5, 7, 9, 11, 13, 16, 17, 18, 19, 22, 24)));
		return agrupador;
	}

	private Agrupador papoDeCunhadoMegaSena() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(2772l, List.of(umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 5, 11, 47, 49, 51, 55), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 5, 28, 29, 35, 41, 43), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 1, 18, 24, 25, 27, 53), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 14, 16, 33, 36, 49, 60), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 16, 29, 36, 39, 44, 47), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 4, 11, 20, 48, 49, 57), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 1, 12, 33, 46, 51, 57), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 1, 13, 16, 19, 29, 37), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 2, 11, 22, 32, 37, 59), umaApostaMegaSena(DateUtil.convertBr("10/09/2024"), 12, 13, 19, 37, 39, 49)));
		agrupador.addApostas(2783l, List.of(umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 3, 9, 10, 31, 52), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 5, 24, 35, 52, 54), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 6, 20, 28, 40, 46, 48), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 7, 14, 16, 24, 25, 36), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 19, 21, 27, 44, 51, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 22, 35, 53, 54, 55, 58), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 12, 24, 28, 31, 34, 45), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 14, 29, 35, 43, 52, 53), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 10, 14, 23, 43, 45, 52), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 7, 31, 41, 47, 49, 58), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 30, 31, 45, 56, 58, 60), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 4, 6, 22, 34, 44, 48), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 13, 15, 24, 36, 56), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 12, 26, 40, 48, 55), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 15, 17, 18, 46, 53, 57), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 5, 17, 21, 40, 52, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 7, 13, 21, 31, 40, 57), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 11, 24, 34, 44, 54), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 3, 15, 16, 33, 34), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 5, 9, 10, 21, 24, 48), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 10, 15, 23, 25, 41, 57), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 17, 20, 30, 52, 58, 60), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 10, 12, 24, 34, 42, 55), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 7, 10, 16, 41, 46, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 4, 16, 41, 43, 50, 57), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 6, 16, 20, 31, 52, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 2, 6, 13, 21, 40, 44), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 8, 13, 27, 40, 50, 54), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 5, 13, 21, 23, 33), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 17, 34, 36, 40, 41, 54)));

		agrupador.addApostas(2788l, List.of(umaApostaMegaSena(DateUtil.convertBr("22/10/2024"), 17, 29, 33, 44, 48, 51), umaApostaMegaSena(DateUtil.convertBr("22/10/2024"), 12, 20, 24, 31, 35, 54), umaApostaMegaSena(DateUtil.convertBr("22/10/2024"), 5, 6, 7, 13, 25, 33, 53, 56)));
		return agrupador;
	}

	private Agrupador sozinhoMegaSena() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(2783l, List.of(umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 16, 19, 37, 39, 41), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 27, 39, 46, 47, 57, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 8, 19, 33, 35, 41, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 6, 20, 35, 38, 46, 58)));
		return agrupador;
	}

	private Agrupador papoDeCunhadoQuina() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(6529l, List.of(umaApostaQuina(DateUtil.convertBr("10/09/2024"), 1, 17, 22, 52, 74), umaApostaQuina(DateUtil.convertBr("10/09/2024"), 15, 24, 56, 67, 80)));
		return agrupador;
	}

	private Aposta umaApostaLotofacil(Date dtSorteio, int... dezenas) {
		return umaAposta(LoteriaEnum.LOTOFACIL, dtSorteio, dezenas);
	}

	private Aposta umaApostaMegaSena(Date dtSorteio, int... dezenas) {
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
