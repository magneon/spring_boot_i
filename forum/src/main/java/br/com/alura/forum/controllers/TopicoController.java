package br.com.alura.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.forum.models.Curso;
import br.com.alura.forum.models.Topico;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TopicoController {
	
	@ResponseBody
	@RequestMapping("/topicos")	
	public List<Topico> topicos() {
		Topico topico = new Topico("Dúvida", "Dúvida no Curso de Spring Boot", new Curso("Spring Boot", "Programação"));
		
		return Arrays.asList(topico, topico, topico);
	}

}
