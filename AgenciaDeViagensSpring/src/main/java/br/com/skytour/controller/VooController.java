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
import br.com.skytour.model.Voo;
import br.com.skytour.repository.VooRepository;

@Controller
@RequestMapping("/voo")
public class VooController {

//CRIAÇÃO DE PROPRIEDADE "vooRepository"
	@Autowired
	private VooRepository vooRepository;

//LISTAGEM DOS PASSAGEIROS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("voo/listar.html");

		List<Voo> voos = vooRepository.findAll();
		modelAndView.addObject("voos", voos);

		return modelAndView;
	}

//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("voo/cadastrar");
		
		modelAndView.addObject("voo", new Voo());
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Voo voo, @RequestParam("fileVoo") MultipartFile file) throws IOException {
		
		try {
			voo.setImagem(file.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/voo");
		
		vooRepository.save(voo);
		
		return modelAndView;
	}
	
//MAPEAMENTO DE IMAGEM E PASSAGEM DE ID PARA A ROTA	
	@GetMapping("/imagem/{idVoo}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idVoo") Long idVoo) {
		Voo voo = this.vooRepository.getOne(idVoo);
		return voo.getImagem();
	}
	
//EXCLUIR VOO DO BANCO DE DADOS
	@GetMapping("/{idVoo}/excluir")
	public ModelAndView excluir(@PathVariable Long idVoo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/voo");
		
		vooRepository.deleteById(idVoo);
		
		return modelAndView;
	}
	
//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idVoo}/editar")
	public ModelAndView editar(@PathVariable Long idVoo) {
		ModelAndView modelAndView = new ModelAndView("voo/edicao");
		
		Voo voo = vooRepository.getOne(idVoo);
		modelAndView.addObject("voo", voo);
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idVoo}/editar")
	public ModelAndView editar(Voo voo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/voo");
		
		vooRepository.save(voo);
		
		return modelAndView;
	}
}
