package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Familia;
import com.gerenciador.condominio.repository.FamiliaRepository;

@Service
public class FamiliaService {
	
	@Autowired
	private FamiliaRepository repository;
	
	public List<Familia> findCondomino() {
		return repository.findAll();
	}
}
