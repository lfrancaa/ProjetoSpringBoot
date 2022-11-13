package br.com.skytour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeResourceController {
	
	@Autowired
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
/*
	@GetMapping("/")
	public String home() {
		return ("<h1>Bem Vindo!</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Bem Vindo Usuário!</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Bem Vindo Administrador!</h1>");
	}
*/
}
