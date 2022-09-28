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

import com.gerenciador.condominio.models.SistemaDeGaragem;
import com.gerenciador.condominio.services.SistemaDeGaragemService;

@RestController
@RequestMapping(value = "/sistemasDeGaragens")
public class SistemaDeGaragemController {
	
	@Autowired
	private SistemaDeGaragemService service;
	
	@GetMapping
	public List<SistemaDeGaragem> findSistemaDeGaragem(){
		return service.findSistemaDeGaragem();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SistemaDeGaragem> find(@PathVariable Long id) {
		SistemaDeGaragem obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody SistemaDeGaragem sistemaDeGaragem){
			sistemaDeGaragem = service.insert(sistemaDeGaragem);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sistemaDeGaragem.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody SistemaDeGaragem sistemaDeGaragem, @PathVariable Long id){
			sistemaDeGaragem.setId(id);
			sistemaDeGaragem = service.update(sistemaDeGaragem);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
