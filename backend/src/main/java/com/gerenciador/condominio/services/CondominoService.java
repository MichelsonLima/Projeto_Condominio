package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Condomino;
import com.gerenciador.condominio.repository.CondominoRepository;

@Service
public class CondominoService {

	@Autowired
	private CondominoRepository repository;

	public List<Condomino> findCondominos() {
		return repository.findAll();
	}

	public Condomino find(Long id) {
		Optional<Condomino> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Condomino insert(Condomino condomino) {
		return repository.save(condomino);
	}

	public Condomino update(Condomino obj) {
		Condomino newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Condomino newObj, Condomino obj) {
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
