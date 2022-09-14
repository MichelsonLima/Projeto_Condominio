package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Visitante;
import com.gerenciador.condominio.repository.VisitanteRepository;

@Service
public class VisitanteService {
	
	@Autowired
	private VisitanteRepository repository;
	
	public List<Visitante> findCondomino() {
		return repository.findAll();
	}
}
