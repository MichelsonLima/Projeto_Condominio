package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Sindico;
import com.gerenciador.condominio.repository.SindicoRepository;

@Service
public class SindicoService {
	
	@Autowired
	private SindicoRepository repository;
	
	public List<Sindico> findCondomino() {
		return repository.findAll();
	}
}
