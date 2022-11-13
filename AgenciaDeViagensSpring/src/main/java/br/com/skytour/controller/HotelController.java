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
import br.com.skytour.model.Hotel;
import br.com.skytour.repository.HotelRepository;

@Controller
@RequestMapping("/hotel")
public class HotelController {

//CRIAÇÃO DE PROPRIEDADE "hotelRepository"
	@Autowired
	private HotelRepository hotelRepository;

//LISTAGEM DOS HOTEIS NO BANCO DE DADOS
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("hotel/listar.html");

		List<Hotel> hoteis = hotelRepository.findAll();
		modelAndView.addObject("hoteis", hoteis);

		return modelAndView;
	}

//CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("hotel/cadastrar");
		
		modelAndView.addObject("hotel", new Hotel());
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Hotel hotel, @RequestParam("fileHotel") MultipartFile file) throws IOException {
		
		try {
			hotel.setImagem(file.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/hotel");
		
		hotelRepository.save(hotel);
		
		return modelAndView;
	}
	
//MAPEAMENTO DE IMAGEM E PASSAGEM DE ID PARA A ROTA	
	@GetMapping("/imagem/{idHotel}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idHotel") Long idHotel) {
		Hotel hotel = this.hotelRepository.getOne(idHotel);
		return hotel.getImagem();
	}
	
//EXCLUIR HOTEL DO BANCO DE DADOS
	@GetMapping("/{idHotel}/excluir")
	public ModelAndView excluir(@PathVariable Long idHotel) {
		ModelAndView modelAndView = new ModelAndView("redirect:/hotel");
		
		hotelRepository.deleteById(idHotel);
		
		return modelAndView;
	}
	
//CHAMA A VIEW EDICAO E PASSA UM OBJETO VAZIO
	@GetMapping("/{idHotel}/editar")
	public ModelAndView editar(@PathVariable Long idHotel) {
		ModelAndView modelAndView = new ModelAndView("hotel/edicao");
		
		Hotel hotel = hotelRepository.getOne(idHotel);
		modelAndView.addObject("hotel", hotel);
		
		return modelAndView;
	}
	
//FAZ O POST DO OBJETO JA PREENCHIDO PARA O BANCO DE DADOS
	@PostMapping("/{idHotel}/editar")
	public ModelAndView editar(Hotel hotel) {
		ModelAndView modelAndView = new ModelAndView("redirect:/hotel");
		
		hotelRepository.save(hotel);
		
		return modelAndView;
	}
}