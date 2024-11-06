package br.com.avsouza7.calculadoradejogos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import br.com.avsouza7.enuns.LoteriaEnum;
import br.com.avsouza7.util.FormataMonetario;

@Service
public class CalcularJogosService {

	public List<ApostasSugeridas> calcularJogos(LoteriaEnum loteriaEnum, BigDecimal montante) {
		Map<Integer, ApostasSugeridas> map = new TreeMap<>();
		EnumMap<LoteriaEnum, Loteria> faixa = faixa();
		Loteria loteria = faixa.get(loteriaEnum);
		List<FaixaLoteria> faixas = loteria.faixas.get(loteriaEnum);
		FaixaLoteria menorFaixa = faixas.stream().min((a, b) -> a.getVlAposta().compareTo(b.getVlAposta())).orElseGet(null);
		BigDecimal totalGasto = BigDecimal.ZERO;
		BigDecimal saldo = montante;
		while (maiorQue(montante, totalGasto) && maiorIgualQue(saldo, menorFaixa.getVlAposta())) {
			boolean apostaFeita = false;
			for (FaixaLoteria faixaLoteria : faixas) {
				if (apostaFeita) {
					continue;
				}
				if (maiorIgualQue(saldo, faixaLoteria.getVlAposta())) {
					totalGasto = totalGasto.add(faixaLoteria.getVlAposta());
					saldo = saldo.subtract(faixaLoteria.getVlAposta());
					ApostasSugeridas doMapa = map.get(faixaLoteria.getQtDezenas());
					if (Objects.isNull(doMapa)) {
						map.put(faixaLoteria.getQtDezenas(), new ApostasSugeridas(loteriaEnum, faixaLoteria));
					} else {
						doMapa.somaMaisUmNaQtApostas();
					}
					apostaFeita = true;
				}
			}
		}
		return new ArrayList<>(map.values());
	}

	private boolean maiorQue(BigDecimal montante, BigDecimal totalGasto) {
		return montante.compareTo(totalGasto) > 0;
	}

	private boolean maiorIgualQue(BigDecimal montante, BigDecimal totalGasto) {
		return montante.compareTo(totalGasto) > 0 || montante.compareTo(totalGasto) == 0;
	}

	private EnumMap<LoteriaEnum, Loteria> faixa() {
		EnumMap<LoteriaEnum, Loteria> faixa = new EnumMap<>(LoteriaEnum.class);
		faixa.put(LoteriaEnum.MEGASENA, new Loteria(LoteriaEnum.MEGASENA));
		return faixa;
	}

	private class Loteria {

		private EnumMap<LoteriaEnum, List<FaixaLoteria>> faixas = new EnumMap<>(LoteriaEnum.class);

		public Loteria(LoteriaEnum loteriaEnum) {
			faixas.put(loteriaEnum, List.of(new FaixaLoteria(loteriaEnum, 20, BigDecimal.valueOf(193800)), new FaixaLoteria(loteriaEnum, 19, BigDecimal.valueOf(135660)), new FaixaLoteria(loteriaEnum, 18, BigDecimal.valueOf(92820)), new FaixaLoteria(loteriaEnum, 17, BigDecimal.valueOf(61880)), new FaixaLoteria(loteriaEnum, 16, BigDecimal.valueOf(40040)), new FaixaLoteria(loteriaEnum, 15, BigDecimal.valueOf(25015)), new FaixaLoteria(loteriaEnum, 14, BigDecimal.valueOf(15015)), new FaixaLoteria(loteriaEnum, 13, BigDecimal.valueOf(8580)), new FaixaLoteria(loteriaEnum, 12, BigDecimal.valueOf(4620)), new FaixaLoteria(loteriaEnum, 11, BigDecimal.valueOf(2310)), new FaixaLoteria(loteriaEnum, 10, BigDecimal.valueOf(1050)), new FaixaLoteria(loteriaEnum, 9, BigDecimal.valueOf(420)), new FaixaLoteria(loteriaEnum, 8, BigDecimal.valueOf(140)), new FaixaLoteria(loteriaEnum, 7, BigDecimal.valueOf(35)), new FaixaLoteria(loteriaEnum, 6, BigDecimal.valueOf(5))));
		}

		public EnumMap<LoteriaEnum, List<FaixaLoteria>> getFaixas() {
			return faixas;
		}

	}

	public class ApostasSugeridas {
		private LoteriaEnum loteriaEnum;
		private Integer qtApostas;
		private Integer qtDezenas;
		private BigDecimal vlAposta;

		public ApostasSugeridas(LoteriaEnum loteriaEnum, FaixaLoteria faixaLoteria) {
			this.loteriaEnum = loteriaEnum;
			this.qtDezenas = faixaLoteria.getQtDezenas();
			this.vlAposta = faixaLoteria.getVlAposta();
			this.qtApostas = 1;
		}

		public LoteriaEnum getLoteriaEnum() {
			return loteriaEnum;
		}

		public void setLoteriaEnum(LoteriaEnum loteriaEnum) {
			this.loteriaEnum = loteriaEnum;
		}

		public Integer getQtApostas() {
			return qtApostas;
		}

		public void somaMaisUmNaQtApostas() {
			this.qtApostas += 1;
		}

		public Integer getQtDezenas() {
			return qtDezenas;
		}

		public void setQtDezenas(Integer qtDezenas) {
			this.qtDezenas = qtDezenas;
		}

		public BigDecimal getVlAposta() {
			return vlAposta;
		}

		public void setVlAposta(BigDecimal vlAposta) {
			this.vlAposta = vlAposta;
		}

		@Override
		public String toString() {
			return "Loteria: " + loteriaEnum.getNome() + "\r\nQuantidae apostas: " + qtApostas + "\r\nQuantidade dezenas: " + qtDezenas + "\r\nValor faixa: " + FormataMonetario.brasileiro(vlAposta);
		}

	}

	public class FaixaLoteria {

		private LoteriaEnum loteriaEnum;
		private Integer qtDezenas;
		private BigDecimal vlAposta;

		public FaixaLoteria(LoteriaEnum loteriaEnum, Integer qtDezenas, BigDecimal vlAposta) {
			this.loteriaEnum = loteriaEnum;
			this.qtDezenas = qtDezenas;
			this.vlAposta = vlAposta;
		}

		public LoteriaEnum getLoteriaEnum() {
			return loteriaEnum;
		}

		public void setLoteriaEnum(LoteriaEnum loteriaEnum) {
			this.loteriaEnum = loteriaEnum;
		}

		public Integer getQtDezenas() {
			return qtDezenas;
		}

		public void setQtDezenas(Integer qtDezenas) {
			this.qtDezenas = qtDezenas;
		}

		public BigDecimal getVlAposta() {
			return vlAposta;
		}

		public void setVlAposta(BigDecimal vlAposta) {
			this.vlAposta = vlAposta;
		}
	}

}
