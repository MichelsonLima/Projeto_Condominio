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

import com.gerenciador.condominio.models.Reserva;
import com.gerenciador.condominio.services.ReservaService;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	@GetMapping
	public List<Reserva> findReserva(){
		return service.findReserva();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Reserva> find(@PathVariable Long id) {
		Reserva obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para obj java automaticamente
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Reserva reserva){
			reserva = service.insert(reserva);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reserva.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody Reserva reserva, @PathVariable Long id){
			reserva.setId(id);
			reserva = service.update(reserva);
			return ResponseEntity.noContent().build();
		}
	
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
