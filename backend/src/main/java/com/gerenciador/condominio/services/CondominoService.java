package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Condomino;
import com.gerenciador.condominio.repository.CondominoRepository;

@Service
public class CondominoService {
	
	@Autowired
	private CondominoRepository repository;
	
	public List<Condomino> findCondomino() {
		return repository.findAll();
	}
}
