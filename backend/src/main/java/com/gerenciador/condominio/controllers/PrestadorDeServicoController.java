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

import com.gerenciador.condominio.models.PrestadorDeServico;
import com.gerenciador.condominio.services.PrestadorDeServicoService;

@RestController
@RequestMapping(value = "/prestadoresDeServicos")
public class PrestadorDeServicoController {
	
	@Autowired
	private PrestadorDeServicoService service;
	
	@GetMapping
	public List<PrestadorDeServico> findPrestadorDeServico(){
		return service.findPrestadorDeServico();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PrestadorDeServico> find(@PathVariable Long id) {
		PrestadorDeServico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody PrestadorDeServico prestadorDeServico){
			prestadorDeServico = service.insert(prestadorDeServico);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prestadorDeServico.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody PrestadorDeServico prestadorDeServico, @PathVariable Long id){
			prestadorDeServico.setId(id);
			prestadorDeServico = service.update(prestadorDeServico);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
