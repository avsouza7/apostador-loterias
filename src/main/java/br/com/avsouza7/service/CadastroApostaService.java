package br.com.avsouza7.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.avsouza7.model.Aposta;
import br.com.avsouza7.model.Apostador;
import br.com.avsouza7.model.CadastroAposta;
import br.com.avsouza7.model.Pessoa;
import br.com.avsouza7.repository.ApostaRepository;
import br.com.avsouza7.repository.ApostadorRepository;

@Service
public class CadastroApostaService {

    @Autowired
    private ApostaRepository apostaRepository;
    @Autowired
    private ApostadorRepository apostadorRepository;

    @Transactional
    public void save(CadastroAposta cadastroAposta) {
	List<Aposta> apostas = new ArrayList<>();
	List<Apostador> apostadores = new ArrayList<>();
	cadastroAposta.getDezenas().stream().filter(d -> !d.isEmpty()).forEach(dz -> {
	    Aposta aposta = new Aposta();
	    aposta.setNuConcurso(cadastroAposta.getIdConcurso());
	    aposta.setIdLoteria(cadastroAposta.getIdLoteria());
	    aposta.setIdGrupo(cadastroAposta.getIdGrupo());
	    aposta.setDtSorteio(cadastroAposta.getDtSorteio());
	    aposta.setDezenasApostadas(dz);
	    apostas.add(aposta);
	});
	cadastroAposta.getApostadores().forEach(a -> {
	    Apostador apostador = apostadorRepository
		    .findByPessoa_IdPessoaAndIdLoteriaAndIdGrupoAndIdConcurso(a.getIdPessoa(),
			    cadastroAposta.getIdLoteria(), cadastroAposta.getIdGrupo(), cadastroAposta.getIdConcurso())
		    .orElseGet(() -> {
			Apostador novo = new Apostador();
			novo.setIdConcurso(cadastroAposta.getIdConcurso());
			novo.setIdGrupo(cadastroAposta.getIdGrupo());
			novo.setIdLoteria(cadastroAposta.getIdLoteria());
			novo.setAporte(BigDecimal.ZERO);
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(a.getIdPessoa());
			novo.setPessoa(pessoa);
			return novo;
		    });
	    apostador.setAporte(apostador.getAporte().add(a.getAporte()));
	    apostadores.add(apostador);
	});
	apostaRepository.saveAll(apostas);
	apostadorRepository.saveAll(apostadores);
    }

    public Optional<CadastroAposta> findById(Long id) {
	CadastroAposta cadastroAposta = new CadastroAposta();
	return Optional.of(cadastroAposta);
    }

}
