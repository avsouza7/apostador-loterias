package br.com.avsouza7.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Contador;
import br.com.avsouza7.provider.SorteioProvider;

@Service
public class ContadorDezenasService {

	private SorteioProvider sorteioProvider;
	private List<Contador> contador;

	public ContadorDezenasService() {
		sorteioProvider = new SorteioProvider();
		contador = new ArrayList<>();
	}

	public List<Contador> getContador(ResultadoFilter filter) {

		return contador;
	}

}
