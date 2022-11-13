package br.com.skytour.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import br.com.skytour.model.Passagem;
import br.com.skytour.repository.PassagemRepository;

@Controller
@RequestMapping("/passagem")
public class PassagemController {

	//CRIAÇÃO DE PROPRIEDADE "passagemRepository"
	@Autowired
	private PassagemRepository passagemRepository;
	
	//LISTAGEM DOS PASSAGEIROS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passagem/listar.html");
		
		List<Passagem> passagens = passagemRepository.findAll();
		modelAndView.addObject("passagens", passagens);
		
		return modelAndView;
	}
	
	//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passagem/cadastrar");
		
		modelAndView.addObject("passagem", new Passagem());
		
		return modelAndView;
	}
	
	//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Passagem passagem) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/passagem");
		
		passagemRepository.save(passagem);
		
		return modelAndView;
	}
	
	//EXCLUIR CLIENTE DO BANCO DE DADOS
	@GetMapping("/{idPassagem}/excluir")
	public ModelAndView excluir(@PathVariable Long idPassagem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passagem");
		
		passagemRepository.deleteById(idPassagem);
		
		return modelAndView;
	}
	
	//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idPassagem}/editar")
	public ModelAndView editar(@PathVariable Long idPassagem) {
		ModelAndView modelAndView = new ModelAndView("passagem/edicao");
		
		Passagem passagem = passagemRepository.getOne(idPassagem);
		modelAndView.addObject("passagem", passagem);
		
		return modelAndView;
	}
	
	//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idPassagem}/editar")
	public ModelAndView editar(Passagem passagem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passagem");
		
		passagemRepository.save(passagem);
		
		return modelAndView;
	}
}
