package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.AreaComum;
import com.gerenciador.condominio.repository.AreaComumRepository;

@Service
public class AreaComumService {

	@Autowired
	private AreaComumRepository repository;

	public List<AreaComum> findAreaComum() {
		return repository.findAll();
	}

	public AreaComum find(Long id) {
		Optional<AreaComum> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public AreaComum insert(AreaComum areaComum) {
		return repository.save(areaComum);
	}

	public AreaComum update(AreaComum obj) {
		AreaComum newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(AreaComum newObj, AreaComum obj) {
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
