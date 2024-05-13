package br.com.avsouza7.provider;

import java.util.ArrayList;
import java.util.List;

import br.com.avsouza7.enuns.LoteriaEnum;
import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Aposta;
import br.com.avsouza7.model.Dezena;

public class ApostaProvider {

	private static final Long ID_APOSTA = 1l;
	private static final int LOTOFACIL[] = new int[] { 1, 2, 4, 7, 8, 9, 10, 12, 13, 14, 17, 19, 21, 24, 25 };
	private static int MEGASENA[] = new int[] { 13, 16, 23, 39, 42, 58 };

	public List<Aposta> getApostas(ResultadoFilter filter) {
		List<Aposta> apostas = new ArrayList<>();
		if (LoteriaEnum.LOTOFACIL.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			apostas.add(umaAposta(LOTOFACIL));
		} else if (LoteriaEnum.MEGASENA.equals(LoteriaEnum.getById(filter.getIdLoteria()))) {
			apostas.add(umaAposta(MEGASENA));
		}
		return apostas;
	}

	private Aposta umaAposta(int valores[]) {
		Aposta aposta = new Aposta();
		aposta.setIdAposta(ID_APOSTA);
		for (int i = 0; i < valores.length; i++) {
			aposta.getDezenas().add(umaDezena(Long.valueOf(valores[i])));
		}
		return aposta;
	}

	private Dezena umaDezena(Long idDezena) {
		Dezena dezena = new Dezena();
		dezena.setIdDezena(idDezena);
		return dezena;
	}

}
