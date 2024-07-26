package br.com.avsouza7.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.avsouza7.filter.ResultadoFilter;
import br.com.avsouza7.model.Sorteio;
import br.com.avsouza7.service.ResultadoService;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

	@Autowired
	private ResultadoService resultadoService;

	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resultadoFilter", new ResultadoFilter());
		modelAndView.setViewName("resultados/consultar");
		return modelAndView;
	}

	@PostMapping("/consultar")
	public ModelAndView consultar(@Valid ResultadoFilter filter, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (filter.getIdConcurso() == null) {
				result.rejectValue("idConcurso", "idConcurso.obrigatorio", "Código Concurso é obrigatório");
			}
			if (result.hasErrors()) {
				modelAndView.addObject("resultadoFilter", filter);
			} else {
				modelAndView.addObject("resultados", resultadoService.getResultados(filter));
				Optional<Sorteio> sorteioDoSite = resultadoService.getSorteioDoSite(filter);
				if (sorteioDoSite.isPresent()) {
					modelAndView.addObject("sorteios", sorteioDoSite.get());
				}
			}
		} catch (Exception e) {
			result.rejectValue("idConcurso", "idConcurso.obrigatorio", e.getMessage());
		}
		modelAndView.setViewName("resultados/consultar");
		return modelAndView;
	}

}
