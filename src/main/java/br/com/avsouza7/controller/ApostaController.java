package br.com.avsouza7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.avsouza7.model.ApostadorDTO;
import br.com.avsouza7.model.CadastroAposta;
import br.com.avsouza7.repository.ApostaRepository;
import br.com.avsouza7.repository.PessoaRepository;
import br.com.avsouza7.service.CadastroApostaService;

@Controller
@RequestMapping("/apostas")
public class ApostaController {

  @Autowired
  private ApostaRepository apostaRepository;
  @Autowired
  private CadastroApostaService cadastroApostaService;
  @Autowired
  private PessoaRepository pessoaRepository;

  @GetMapping("/listar")
  public ModelAndView listar() {
    ModelAndView mv = new ModelAndView("apostas/listar");
    mv.addObject("apostas", apostaRepository.findAll(Sort.by(Sort.Direction.DESC, "dtSorteio")));
    return mv;
  }

  @GetMapping("/novo")
  public ModelAndView novo() {
    ModelAndView mv = new ModelAndView("apostas/cadastro");
    CadastroAposta cadastro = new CadastroAposta();
    cadastro.getDezenas().add("");
    pessoaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"))
        .forEach(p -> cadastro.getApostadores().add(new ApostadorDTO(p)));
    mv.addObject("aposta", cadastro);
    return mv;
  }

  @GetMapping("/{id}/editar")
  public ModelAndView editar(@PathVariable Long id) {
    ModelAndView mv = new ModelAndView("apostas/cadastro");
    mv.addObject("aposta", cadastroApostaService.findById(id).orElseThrow());
    return mv;
  }

  @PostMapping("/salvar")
  public String salvar(@ModelAttribute CadastroAposta aposta) {
    cadastroApostaService.save(aposta);
    return "redirect:/apostas/listar";
  }

  @GetMapping("/{id}/excluir")
  public String excluir(@PathVariable Long id) {
    apostaRepository.deleteById(id);
    return "redirect:/apostas/listar";
  }

}
