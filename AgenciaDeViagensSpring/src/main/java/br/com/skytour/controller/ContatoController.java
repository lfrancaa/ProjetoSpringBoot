package br.com.skytour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {
	
	@RequestMapping("/contato")
	@ResponseBody
	
	public ModelAndView contato() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contato.html");
		return modelAndView;
	}
}
