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
		apostas.put(GrupoEnum.INIMIGOS_DO_FIM, inimigosDoFimMegaSena());
		apostas.put(GrupoEnum.TORUS_5A_SERIE, torus5aSerieMegaSena());
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
		agrupador.addApostas(3226l, List.of(umaApostaLotofacil(DateUtil.convertBr("22/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3227l, List.of(umaApostaLotofacil(DateUtil.convertBr("23/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("23/10/2024"), 3, 4, 5, 6, 10, 12, 13, 14, 15, 16, 17, 21, 22, 23, 24), umaApostaLotofacil(DateUtil.convertBr("23/10/2024"), 3, 4, 5, 6, 7, 8, 12, 14, 15, 16, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("23/10/2024"), 4, 5, 7, 8, 9, 10, 14, 15, 16, 17, 19, 20, 21, 24, 25), umaApostaLotofacil(DateUtil.convertBr("23/10/2024"), 1, 2, 5, 6, 10, 12, 13, 14, 15, 16, 17, 19, 21, 24, 25)));
		agrupador.addApostas(3228l, List.of(umaApostaLotofacil(DateUtil.convertBr("24/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3229l, List.of(umaApostaLotofacil(DateUtil.convertBr("25/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3230l, List.of(umaApostaLotofacil(DateUtil.convertBr("26/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3231l, List.of(umaApostaLotofacil(DateUtil.convertBr("28/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3232l, List.of(umaApostaLotofacil(DateUtil.convertBr("29/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25)));
		agrupador.addApostas(3233l, List.of(umaApostaLotofacil(DateUtil.convertBr("30/10/2024"), 1, 2, 3, 4, 8, 9, 10, 11, 16, 18, 20, 21, 22, 23, 25), umaApostaLotofacil(DateUtil.convertBr("30/10/2024"), 1, 3, 5, 6, 7, 13, 14, 15, 17, 18, 19, 20, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("30/10/2024"), 1, 2, 6, 7, 8, 9, 10, 11, 12, 14, 16, 18, 19, 24, 25), umaApostaLotofacil(DateUtil.convertBr("30/10/2024"), 2, 3, 5, 6, 7, 8, 9, 11, 13, 4, 16, 18, 20, 22, 24), umaApostaLotofacil(DateUtil.convertBr("30/10/2024"), 1, 3, 4, 7, 9, 10, 12, 14, 15, 17, 18, 19, 22, 24, 25)));
		agrupador.addApostas(3236l, List.of(umaApostaLotofacil(DateUtil.convertBr("04/11/2024"), 1, 2, 5, 8, 10, 11, 12, 14, 15, 17, 18, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("04/11/2024"), 3, 6, 7, 8, 10, 11, 12, 15, 17, 18, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("04/11/2024"), 1, 3, 4, 9, 11, 12, 14, 17, 18, 20, 21, 22, 23, 24, 25)));
		agrupador.addApostas(3237l, List.of(umaApostaLotofacil(DateUtil.convertBr("05/11/2024"), 1, 2, 5, 8, 10, 11, 12, 14, 15, 17, 18, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("05/11/2024"), 3, 6, 7, 8, 10, 11, 12, 15, 17, 18, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("05/11/2024"), 1, 3, 4, 9, 11, 12, 14, 17, 18, 20, 21, 22, 23, 24, 25)));
		agrupador.addApostas(3238l, List.of(umaApostaLotofacil(DateUtil.convertBr("06/11/2024"), 1, 2, 5, 8, 10, 11, 12, 14, 15, 17, 18, 19, 21, 22, 25), umaApostaLotofacil(DateUtil.convertBr("06/11/2024"), 3, 6, 7, 8, 10, 11, 12, 15, 17, 18, 20, 22, 23, 24, 25), umaApostaLotofacil(DateUtil.convertBr("06/11/2024"), 1, 3, 4, 9, 11, 12, 14, 17, 18, 20, 21, 22, 23, 24, 25)));
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
		agrupador.addApostas(2789l, List.of(umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 2, 9, 16, 17, 26, 38), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 12, 13, 23, 35, 55, 59), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 5, 13, 28, 32, 44, 50), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 1, 15, 20, 28, 53, 58), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 5, 9, 26, 32, 49, 53), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 16, 24, 33, 41, 56, 60), umaApostaMegaSena(DateUtil.convertBr("24/10/2024"), 11, 14, 18, 26, 42, 57)));
		agrupador.addApostas(2791l, List.of(umaApostaMegaSena(DateUtil.convertBr("29/10/2024"), 7, 23, 35, 37, 47, 58), umaApostaMegaSena(DateUtil.convertBr("29/10/2024"), 20, 28, 29, 38, 44, 59), umaApostaMegaSena(DateUtil.convertBr("29/10/2024"), 6, 7, 14, 19, 20, 22, 44, 48)));
		agrupador.addApostas(2792l, List.of(umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 19, 20, 24, 25, 33, 35), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 2, 9, 16, 17, 26, 38), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 7, 8, 12, 19, 28, 42), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 16, 22, 34, 45, 50, 57), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 11, 12, 31, 43, 49, 57), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 6, 21, 34, 42, 48, 52), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 7, 21, 31, 32, 35, 40), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 6, 7, 15, 23, 45, 51), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 24, 42, 47, 51, 53, 54), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 2, 4, 12, 32, 51, 52), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 9, 17, 19, 33, 46, 58), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 11, 18, 29, 33, 43, 59), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 12, 19, 26, 34, 51, 53), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 31, 33, 35, 38, 49, 55), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 11, 13, 25, 31, 34, 55), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 6, 11, 13, 47, 54, 55), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 10, 16, 20, 27, 29, 56), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 4, 40, 42, 46, 59, 60), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 15, 28, 40, 43, 47, 54), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 24, 27, 35, 38, 45, 56), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 4, 22, 24, 25, 29, 44), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 1, 24, 34, 50, 53, 57), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 9, 24, 30, 39, 42, 53), umaApostaMegaSena(DateUtil.convertBr("01/11/2024"), 8, 14, 23, 32, 47, 57)));
		agrupador.addApostas(2793l, List.of(umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 10, 16, 23, 38, 51), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 4, 11, 19, 35, 36, 51), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 46, 51, 52, 53, 54), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 19, 22, 28, 37, 60), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 8, 35, 46, 47, 50), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 4, 12, 21, 24, 35), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 12, 23, 27, 39, 45), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 21, 24, 25, 39, 40, 43), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 8, 9, 18, 22, 39), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 6, 24, 28, 36, 42, 56), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 34, 42, 46, 47, 53), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 10, 28, 31, 48, 54, 55), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 11, 26, 33, 40, 58), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 11, 16, 21, 33, 36, 56), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 2, 9, 16, 17, 26, 38), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 8, 21, 36, 43, 50), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 11, 19, 25, 29, 52), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 6, 11, 24, 46, 59), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 17, 22, 30, 45, 54, 55), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 13, 28, 33, 41, 49, 60), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 16, 19, 21, 31, 45), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 4, 7, 19, 39, 52), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 5, 13, 15, 26, 30, 55), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 17, 18, 19, 21, 23, 57), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 12, 28, 47, 53, 60), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 23, 28, 34, 35, 47, 58), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 4, 29, 39, 52, 53, 59), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 20, 28, 29, 32, 51, 60), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 1, 11, 42, 47, 52, 60), umaApostaMegaSena(DateUtil.convertBr("05/11/2024"), 24, 27, 43, 48, 50, 60)));
		agrupador.addApostas(2794l, List.of(umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 5, 33, 41, 43, 50, 60), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 7, 9, 31, 37, 44, 60), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 30, 37, 40, 42, 52, 54), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 12, 20, 25, 32, 52, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 2, 5, 33, 39, 40, 48), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 8, 16, 18, 37, 44, 53), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 5, 12, 24, 36, 55, 57), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 11, 19, 34, 35, 46, 52), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 19, 26, 30, 35, 47, 50), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 6, 13, 17, 39, 48, 60), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 20, 26, 27, 50, 52, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 17, 19, 41, 43, 44, 50), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 3, 20, 23, 29, 44, 53), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 3, 14, 24, 34, 38, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 6, 29, 39, 42, 45, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 2, 4, 17, 19, 40, 58), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 14, 25, 36, 38, 44, 58), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 7, 31, 41, 42, 52, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 4, 9, 11, 15, 41, 56), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 12, 23, 24, 44, 53, 60), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 13, 18, 21, 27, 31, 39), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 3, 10, 11, 39, 45, 52), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 4, 9, 20, 37, 43, 59), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 12, 18, 27, 36, 38, 58), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 1, 6, 11, 24, 46, 59), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 17, 22, 30, 45, 54, 55), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 13, 28, 33, 41, 49, 60), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 2, 9, 16, 17, 26, 38), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 10, 11, 19, 20, 24, 39), umaApostaMegaSena(DateUtil.convertBr("07/11/2024"), 5, 8, 21, 36, 43, 50)));
		return agrupador;
	}

	private Agrupador sozinhoMegaSena() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(2783l, List.of(umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 16, 19, 37, 39, 41), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 27, 39, 46, 47, 57, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 8, 19, 33, 35, 41, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 1, 6, 20, 35, 38, 46, 58)));
		return agrupador;
	}

	private Agrupador inimigosDoFimMegaSena() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(2793l, List.of(umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 5, 6, 11, 18, 25, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 9, 15, 16, 27, 35, 59), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 17, 22, 28, 34, 41, 49), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 4, 19, 21, 23, 38, 57), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 13, 19, 34, 39, 47, 53, 60), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 3, 6, 15, 39, 40, 45, 52), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 5, 15, 29, 31, 32, 34), umaApostaMegaSena(DateUtil.convertBr("05/10/2024"), 16, 33, 39, 40, 41, 44)

		));
		return agrupador;
	}

	private Agrupador torus5aSerieMegaSena() {
		Agrupador agrupador = new Agrupador();
		agrupador.addApostas(2793l, List.of(umaApostaQuina(DateUtil.convertBr("05/11/2024"), 2, 7, 10, 16, 44, 59, 60), umaApostaQuina(DateUtil.convertBr("05/11/2024"), 8, 13, 16, 29, 35, 43), umaApostaQuina(DateUtil.convertBr("05/11/2024"), 1, 34, 38, 41, 46, 58), umaApostaQuina(DateUtil.convertBr("05/11/2024"), 1, 05, 23, 25, 29, 38, 39), umaApostaQuina(DateUtil.convertBr("05/11/2024"), 4, 15, 19, 31, 52, 58, 59, 60)));
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
