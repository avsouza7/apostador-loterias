package br.com.avsouza7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.avsouza7.model.CadastroAposta;
import br.com.avsouza7.repository.ApostaRepository;

@Service
public class CadastroApostaService {

  @Autowired
  private ApostaRepository apostaRepository;

  public void save(CadastroAposta cadastroAposta) {

  }

}
