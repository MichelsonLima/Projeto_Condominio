package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.SistemaDeGaragem;
import com.gerenciador.condominio.repository.SistemaDeGaragemRepository;

@Service
public class SistemaDeGaragemService {

	@Autowired
	private SistemaDeGaragemRepository repository;

	public List<SistemaDeGaragem> findSistemaDeGaragem() {
		return repository.findAll();
	}

	public SistemaDeGaragem find(Long id) {
		Optional<SistemaDeGaragem> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public SistemaDeGaragem insert(SistemaDeGaragem sistemaDeGaragem) {
		return repository.save(sistemaDeGaragem);
	}

	// Quando id não está nulo ele atualiza
	public SistemaDeGaragem update(SistemaDeGaragem obj) {
		SistemaDeGaragem newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(SistemaDeGaragem newObj, SistemaDeGaragem obj) {
		newObj.setNumero(obj.getNumero());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

		}
	}
}
