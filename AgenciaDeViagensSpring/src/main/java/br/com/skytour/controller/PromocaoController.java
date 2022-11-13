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
import br.com.skytour.model.Promocao;
import br.com.skytour.repository.PromocaoRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

//CRIAÇÃO DE PROPRIEDADE "promocaoRepository"
	@Autowired
	private PromocaoRepository promocaoRepository;

//LISTAGEM DOS DESTINOS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("promocao/listar.html");

		List<Promocao> promocoes = promocaoRepository.findAll();
		modelAndView.addObject("promocoes", promocoes);

		return modelAndView;
	}

//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("promocao/cadastrar");
		
		modelAndView.addObject("promocao", new Promocao());
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Promocao promocao, @RequestParam("filePromocao") MultipartFile file) throws IOException {
		
		try {
			promocao.setImagem(file.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
		
		promocaoRepository.save(promocao);
		
		return modelAndView;
	}
	
//MAPEAMENTO DE IMAGEM E PASSAGEM DE ID PARA A ROTA	
	@GetMapping("/imagem/{idPromocao}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idPromocao") Long idPromocao) {
		Promocao promocao = this.promocaoRepository.getOne(idPromocao);
		return promocao.getImagem();
	}
	
//EXCLUIR DESTINO DO BANCO DE DADOS
	@GetMapping("/{idPromocao}/excluir")
	public ModelAndView excluir(@PathVariable Long idPromocao) {
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
		
		promocaoRepository.deleteById(idPromocao);
		
		return modelAndView;
	}
	
//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idPromocao}/editar")
	public ModelAndView editar(@PathVariable Long idPromocao) {
		ModelAndView modelAndView = new ModelAndView("promocao/edicao");
		
		Promocao promocao = promocaoRepository.getOne(idPromocao);
		modelAndView.addObject("promocao", promocao);
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idPromocao}/editar")
	public ModelAndView editar(Promocao promocao) {
		ModelAndView modelAndView = new ModelAndView("redirect:/promocao");
		
		promocaoRepository.save(promocao);
		
		return modelAndView;
	}

}
