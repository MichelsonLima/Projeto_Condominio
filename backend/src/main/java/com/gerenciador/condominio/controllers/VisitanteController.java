package com.gerenciador.condominio.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.condominio.models.Visitante;
import com.gerenciador.condominio.services.VisitanteService;

@RestController
@RequestMapping(value = "/visitantes")
public class VisitanteController {
	
	@Autowired
	private VisitanteService service;
	
	@GetMapping
	public List<Visitante> findVisitante(){
		return service.findVisitante();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Visitante> find(@PathVariable Long id) {
		Visitante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Visitante visitante){
			visitante = service.insert(visitante);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(visitante.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Visitante visitante, @PathVariable Long id){
			visitante.setId(id);
			visitante = service.update(visitante);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
