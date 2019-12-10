package br.com.alura.forum.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controllers.dtos.TopicoDTO;
import br.com.alura.forum.controllers.forms.TopicoForm;
import br.com.alura.forum.models.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;

@RestController
@RequestMapping("/topicos")	
public class TopicoController {
	
	@Autowired
	private TopicoRepository repositoryTopico;
	
	@Autowired
	private CursoRepository repositoryCurso;
	
	@GetMapping
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
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(repositoryCurso);
		
		repositoryTopico.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}

}