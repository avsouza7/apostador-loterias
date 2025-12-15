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
import br.com.avsouza7.model.Pessoa;
import br.com.avsouza7.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    // LISTAR
    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("pessoas/listar");
        mv.addObject("pessoas", repository.findAll(Sort.by(Sort.Direction.ASC, "nome")));
        return mv;
    }

    // FORM NOVO
    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("pessoas/cadastro");
        mv.addObject("pessoa", new Pessoa());
        return mv;
    }

    // FORM EDITAR
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("pessoas/cadastro");
        mv.addObject("pessoa",
                repository.findById(id).orElseThrow());
        return mv;
    }

    // SALVAR (novo e edição)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Pessoa pessoa) {
        repository.save(pessoa);
        return "redirect:/pessoas/listar";
    }

    // EXCLUIR
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/pessoas/listar";
    }
}


