package br.com.skytour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SobreController {
	
	@RequestMapping("/sobre")
	@ResponseBody
	
	public ModelAndView sobre() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sobre.html");
		return modelAndView;
	}
}
