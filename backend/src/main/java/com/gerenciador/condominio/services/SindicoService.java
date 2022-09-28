package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Sindico;
import com.gerenciador.condominio.repository.SindicoRepository;

@Service
public class SindicoService {

	@Autowired
	private SindicoRepository repository;

	public List<Sindico> findSindico() {
		return repository.findAll();
	}

	public Sindico find(Long id) {
		Optional<Sindico> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Sindico insert(Sindico sindico) {
		return repository.save(sindico);
	}

	// Quando id não está nulo ele atualiza
	public Sindico update(Sindico obj) {
		Sindico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Sindico newObj, Sindico obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

		}
	}
}
