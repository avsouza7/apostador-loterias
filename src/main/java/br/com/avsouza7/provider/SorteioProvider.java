package br.com.avsouza7.provider;

import java.net.URI;
import java.util.Optional;

import org.springframework.web.client.RestTemplate;

import br.com.avsouza7.exceptions.LeituraException;
import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Sorteio;

public class SorteioProvider {
	private static final String OPS_ALGUMA_COISA_NAO_SAIU_COMO_ESPERADO = "Ops! Alguma coisa não saiu como esperado.";
	private static final String URL = "https://servicebus2.caixa.gov.br/portaldeloterias/api/%s/%s";

	public Optional<Sorteio> getSorteioDoSite(ResultadoFilter filter) {
		try {
			URI uri = new URI(String.format(URL, filter.getLoteriaEnum().name(), filter.getIdConcurso()));
			return Optional.of(new RestTemplate().getForObject(uri, Sorteio.class));
		} catch (Exception e) {
			throw new LeituraException(OPS_ALGUMA_COISA_NAO_SAIU_COMO_ESPERADO, e);
		}

	}

}
