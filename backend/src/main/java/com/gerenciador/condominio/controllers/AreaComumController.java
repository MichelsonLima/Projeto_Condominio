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

import com.gerenciador.condominio.models.AreaComum;
import com.gerenciador.condominio.services.AreaComumService;

@RestController
@RequestMapping(value = "/areasComuns")
public class AreaComumController {
	
	@Autowired
	private AreaComumService service;
	
	@GetMapping
	public List<AreaComum> findAreaComum(){
		return service.findAreaComum();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AreaComum> find(@PathVariable Long id) {
		AreaComum obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody AreaComum areaComum){
			areaComum = service.insert(areaComum);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(areaComum.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody AreaComum areaComum, @PathVariable Long id){
			areaComum.setId(id);
			areaComum = service.update(areaComum);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
