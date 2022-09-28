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

import com.gerenciador.condominio.models.Condomino;
import com.gerenciador.condominio.services.CondominoService;

@RestController
@RequestMapping(value = "/condominos")
public class CondominoController {

	@Autowired
	private CondominoService service;

	@GetMapping
	public List<Condomino> findCondominos() {
		return service.findCondominos();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Condomino> find(@PathVariable Long id) {
		Condomino obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Condomino condomino){
			condomino = service.insert(condomino);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(condomino.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Condomino condomino, @PathVariable Long id){
			condomino.setId(id);
			condomino = service.update(condomino);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}

}
