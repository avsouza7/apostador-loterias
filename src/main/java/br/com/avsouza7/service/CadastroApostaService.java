package br.com.avsouza7.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

  public void save(CadastroAposta cadastroAposta) {
    List<Aposta> apostas = new ArrayList<>();
    List<Apostador> apostadores = new ArrayList<>();
    cadastroAposta.getDezenas().forEach(a -> {
      Aposta aposta = new Aposta();
      aposta.setNuConcurso(cadastroAposta.getIdConcurso());
      aposta.setIdLoteria(cadastroAposta.getIdLoteria());
      aposta.setIdGrupo(cadastroAposta.getIdGrupo());
      aposta.setDtSorteio(cadastroAposta.getDtSorteio());
      aposta.setDezenasApostadas(a);
      apostas.add(aposta);
    });
    cadastroAposta.getApostadores().forEach(a -> {
      Apostador apostador = new Apostador();
      apostador.setIdConcurso(cadastroAposta.getIdConcurso());
      apostador.setIdGrupo(cadastroAposta.getIdGrupo());
      apostador.setIdLoteria(cadastroAposta.getIdLoteria());
      apostador.setAporte(a.getAporte());
      Pessoa pessoa = new Pessoa();
      pessoa.setIdPessoa(a.getIdPessoa());
      apostador.setPessoa(pessoa);
      apostadores.add(apostador);
    });
    apostaRepository.saveAll(apostas);
    apostadorRepository.saveAll(apostadores);
  }

}
