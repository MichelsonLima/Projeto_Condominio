package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.Visitante;
import com.gerenciador.condominio.services.VisitanteService;

@RestController
@RequestMapping(value = "/visitante")
public class VisitanteController {
	
	@Autowired
	private VisitanteService service;
	
	@GetMapping
	public List<Visitante> findCondomino(){
		return service.findCondomino();
	}
}
