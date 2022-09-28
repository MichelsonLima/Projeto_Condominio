package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Pessoa;
import com.gerenciador.condominio.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findPessoa() {
		return repository.findAll();
	}
}
