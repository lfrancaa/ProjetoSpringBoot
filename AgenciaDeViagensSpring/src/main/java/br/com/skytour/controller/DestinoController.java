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
import br.com.skytour.model.Destino;
import br.com.skytour.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

//CRIAÇÃO DE PROPRIEDADE "destinoRepository"
	@Autowired
	private DestinoRepository destinoRepository;

//LISTAGEM DOS PASSAGEIROS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("destino/listar.html");

		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("destinos", destinos);

		return modelAndView;
	}

//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("destino/cadastrar");
		
		modelAndView.addObject("destino", new Destino());
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Destino destino, @RequestParam("fileDestino") MultipartFile file) throws IOException {
		
		try {
			destino.setImagem(file.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
		
		destinoRepository.save(destino);
		
		return modelAndView;
	}
	
//MAPEAMENTO DE IMAGEM E PASSAGEM DE ID PARA A ROTA	
	@GetMapping("/imagem/{idDestino}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idDestino") Long idDestino) {
		Destino destino = this.destinoRepository.getOne(idDestino);
		return destino.getImagem();
	}

//EXCLUIR DESTINO DO BANCO DE DADOS
	@GetMapping("/{idDestino}/excluir")
	public ModelAndView excluir(@PathVariable Long idDestino) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
		
		destinoRepository.deleteById(idDestino);
		
		return modelAndView;
	}

//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idDestino}/editar")
	public ModelAndView editar(@PathVariable Long idDestino) {
		ModelAndView modelAndView = new ModelAndView("destino/edicao");
		
		Destino destino = destinoRepository.getOne(idDestino);
		modelAndView.addObject("destino", destino);
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idDestino}/editar")
	public ModelAndView editar(Destino destino) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
		
		destinoRepository.save(destino);
		
		return modelAndView;
	}
}
