package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.Condomino;
import com.gerenciador.condominio.services.CondominoService;

@RestController
@RequestMapping(value = "/condomino")
public class CondominoController {
	
	@Autowired
	private CondominoService service;
	
	@GetMapping
	public List<Condomino> findCondomino(){
		return service.findCondomino();
	}
}
