package br.com.avsouza7.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Aposta;
import br.com.avsouza7.model.Premio;
import br.com.avsouza7.model.Resultado;
import br.com.avsouza7.model.Sorteio;
import br.com.avsouza7.provider.ApostaProvider;
import br.com.avsouza7.provider.SorteioProvider;
import br.com.avsouza7.util.FormataMonetario;

@Service
public class ResultadoService {

	private ApostaProvider apostaProvider = new ApostaProvider();;
	private SorteioProvider sorteioProvider = new SorteioProvider();

	public List<Resultado> getResultados(ResultadoFilter filter) {
		List<Resultado> resultados = new ArrayList<>();
		Optional<Sorteio> optional = getSorteioDoSite(filter);
		List<Aposta> apostas = apostaProvider.getApostas(filter);
		if (optional.isPresent()) {
			Sorteio sorteio = optional.get();
			apostas.forEach(aposta -> resultados.add(getResultado(filter, aposta, sorteio)));
		}
		return resultados;
	}

	public Optional<Sorteio> getSorteioDoSite(ResultadoFilter filter) {
		return sorteioProvider.getSorteioDoSite(filter);
	}

	private Resultado getResultado(ResultadoFilter filter, Aposta aposta, Sorteio sorteio) {
		Resultado resultado = new Resultado();
		resultado.setDtSorteio(sorteio.getDtSorteio());
		resultado.setIdConcurso(sorteio.getIdConcurso());
		resultado.setIdLoteria(filter.getIdLoteria());
		aposta.getDezenas().forEach(dezenaAposta -> {
			boolean foiSorteada = sorteio.getDezenas().contains(dezenaAposta);
			dezenaAposta.setFoiSorteada(foiSorteada);
			if (foiSorteada) {
				resultado.setNuAcertos(resultado.getNuAcertos() + 1);
			}
			resultado.getDezenas().add(dezenaAposta);
		});
		resultado.setVlPremio(getVlPremio(resultado, sorteio));
		return resultado;
	}

	private String getVlPremio(Resultado resultado, Sorteio sorteio) {
		Map<Integer, String> mapaDeFaixas = getMapaDeFaixas(sorteio.getPremios());
		return mapaDeFaixas.get(resultado.getFaixa());
	}

	private Map<Integer, String> getMapaDeFaixas(List<Premio> premios) {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, FormataMonetario.brasileiro(BigDecimal.ZERO));
		premios.forEach(premio -> map.put(premio.getFaixa(), FormataMonetario.brasileiro(premio.getVlPremio())));
		return map;
	}
}
