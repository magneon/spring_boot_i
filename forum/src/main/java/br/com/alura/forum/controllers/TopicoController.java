package br.com.alura.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controllers.dtos.TopicoDTO;
import br.com.alura.forum.models.Curso;
import br.com.alura.forum.models.Topico;

@RestController
public class TopicoController {
	
	@RequestMapping("/topicos")	
	public List<TopicoDTO> topicos() {
		Topico topico = new Topico("Dúvida", "Dúvida no Curso de Spring Boot", new Curso("Spring Boot", "Programação"));
		
		return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
	}

}
