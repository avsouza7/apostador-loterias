package br.com.avsouza7.model;

import java.math.BigDecimal;

public class ApostadorDTO {

  private Long idPessoa;
  private String nome;
  private BigDecimal aporte;

  public ApostadorDTO() {
    aporte = BigDecimal.ZERO;
  }

  public ApostadorDTO(Pessoa pessoa) {
    this();
    setIdPessoa(pessoa.getIdPessoa());
    setNome(pessoa.getNome());
  }

  public Long getIdPessoa() {
    return idPessoa;
  }

  public void setIdPessoa(Long idPessoa) {
    this.idPessoa = idPessoa;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getAporte() {
    return aporte;
  }

  public void setAporte(BigDecimal aporte) {
    this.aporte = aporte;
  }
}
