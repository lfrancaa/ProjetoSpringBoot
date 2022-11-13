package br.com.skytour.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.skytour.model.Passageiro;
import br.com.skytour.repository.PassageiroRepository;

@Controller
@RequestMapping("/passageiro")
public class PassageiroController {

//CRIAÇÃO DE PROPRIEDADE "passageirosRepository"
	@Autowired
	private PassageiroRepository passageiroRepository;

//LISTAGEM DOS PASSAGEIROS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passageiro/listar.html");

		List<Passageiro> passageiros = passageiroRepository.findAll();
		modelAndView.addObject("passageiros", passageiros);

		return modelAndView;
	}
	
	
	/* 
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("passageiro/cadastrar");

        modelAndView.addObject("passageiro", new Passageiro());


        return modelAndView;
    }
	
	@PostMapping("/cadastrar")
    public ModelAndView cadastrar(Passageiro passageiro) throws IOException {
       String senhaEncriptada = SenhaUtils.encode(passageiro.getSenha());

        passageiro.setSenha(senhaEncriptada);
		ModelAndView modelAndView = new ModelAndView("redirect:/passageiro");
        passageiroRepository.save(passageiro);

        return modelAndView;
    }
	*/
	

//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passageiro/cadastrar");

		modelAndView.addObject("passageiro", new Passageiro());

		return modelAndView;
	}

//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Passageiro passageiro) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/passageiro");

		passageiroRepository.save(passageiro);

		return modelAndView;
	}/*
*/
//DETALHAR DADOS COMPLEMENTARES DO CLIENTE	
	@GetMapping("/{idPassageiro}")
	public ModelAndView detalhar(@PathVariable Long idPassageiro) {
		ModelAndView modelAndView = new ModelAndView("passageiro/detalhar.html");

		Passageiro passageiro = passageiroRepository.getOne(idPassageiro);
		modelAndView.addObject("passageiro", passageiro);

		return modelAndView;
	}

//EXCLUIR CLIENTE DO BANCO DE DADOS
	@GetMapping("/{idPassageiro}/excluir")
	public ModelAndView excluir(@PathVariable Long idPassageiro) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passageiro");

		passageiroRepository.deleteById(idPassageiro);

		return modelAndView;
	}

//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idPassageiro}/editar")
	public ModelAndView editar(@PathVariable Long idPassageiro) {
		ModelAndView modelAndView = new ModelAndView("passageiro/edicao");

		Passageiro passageiro = passageiroRepository.getOne(idPassageiro);
		modelAndView.addObject("passageiro", passageiro);

		return modelAndView;
	}

//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idPassageiro}/editar")
	public ModelAndView editar(Passageiro passageiro) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passageiro");

		passageiroRepository.save(passageiro);

		return modelAndView;
	}
}
