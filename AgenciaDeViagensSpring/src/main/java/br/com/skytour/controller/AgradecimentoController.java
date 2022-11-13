package br.com.skytour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgradecimentoController {
	
	@RequestMapping("/agradecimento")
	@ResponseBody
	
	public ModelAndView contato() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("agradecimento.html");
		return modelAndView;
	}
}
