package br.com.skytour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	@ResponseBody
	
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.html");
		return modelAndView;
	}
}
