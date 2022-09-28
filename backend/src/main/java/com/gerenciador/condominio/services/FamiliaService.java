package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Familia;
import com.gerenciador.condominio.repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	private FamiliaRepository repository;

	public List<Familia> findFamilia() {
		return repository.findAll();
	}

	public Familia find(Long id) {
		Optional<Familia> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Familia insert(Familia familia) {
		return repository.save(familia);
	}

	// Quando id não está nulo ele atualiza
	public Familia update(Familia obj) {
		Familia newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Familia newObj, Familia obj) {
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
