package com.gerenciador.condominio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.condominio.models.Pessoa;
import com.gerenciador.condominio.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public List<Pessoa> findCondomino(){
		return service.findPessoa();
	}
}
