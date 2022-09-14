package com.gerenciador.condominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.PrestadorDeServico;
import com.gerenciador.condominio.repository.PrestadorDeServicoRepository;

@Service
public class PrestadorDeServicoService {
	
	@Autowired
	private PrestadorDeServicoRepository repository;
	
	public List<PrestadorDeServico> findCondomino() {
		return repository.findAll();
	}
}
