package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.Sindico;
import com.gerenciador.condominio.services.SindicoService;

@RestController
@RequestMapping(value = "/sindico")
public class SindicoController {
	
	@Autowired
	private SindicoService service;
	
	@GetMapping
	public List<Sindico> findCondomino(){
		return service.findCondomino();
	}
}
