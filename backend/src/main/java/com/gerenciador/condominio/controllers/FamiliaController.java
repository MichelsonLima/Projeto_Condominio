package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.Familia;
import com.gerenciador.condominio.services.FamiliaService;

@RestController
@RequestMapping(value = "/familia")
public class FamiliaController {
	
	@Autowired
	private FamiliaService service;
	
	@GetMapping
	public List<Familia> findCondomino(){
		return service.findCondomino();
	}
}
