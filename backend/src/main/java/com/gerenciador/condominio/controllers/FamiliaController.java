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

import com.gerenciador.condominio.models.Familia;
import com.gerenciador.condominio.services.FamiliaService;

@RestController
@RequestMapping(value = "/familias")
public class FamiliaController {
	
	@Autowired
	private FamiliaService service;
	
	@GetMapping
	public List<Familia> findFamilia(){
		return service.findFamilia();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Familia> find(@PathVariable Long id) {
		Familia obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Familia familia){
			familia = service.insert(familia);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(familia.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Familia familia, @PathVariable Long id){
			familia.setId(id);
			familia = service.update(familia);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	
}
