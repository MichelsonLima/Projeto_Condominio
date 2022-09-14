package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.PrestadorDeServico;
import com.gerenciador.condominio.services.PrestadorDeServicoService;

@RestController
@RequestMapping(value = "/prestadorDeServico")
public class PrestadorDeServicoController {
	
	@Autowired
	private PrestadorDeServicoService service;
	
	@GetMapping
	public List<PrestadorDeServico> findCondomino(){
		return service.findCondomino();
	}
}
