package br.com.alura.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controllers.dtos.TopicoDTO;
import br.com.alura.forum.models.Topico;
import br.com.alura.forum.repositories.TopicoRepository;

@RestController
public class TopicoController {
	
	@Autowired
	private TopicoRepository repositoryTopico;
	
	@RequestMapping("/topicos")	
	public List<TopicoDTO> topicos(String nomeCurso) {
		List<Topico> topicos = null;
		if (nomeCurso == null) {
			topicos = repositoryTopico.findAll();
		} else {
			topicos = repositoryTopico.findByCursoNome(nomeCurso);
//			topicos = repositoryTopico.pegaPorCursoNome(nomeCurso);
		}
		return TopicoDTO.converter(topicos);
	}

}
