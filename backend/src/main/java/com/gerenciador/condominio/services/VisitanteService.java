package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Visitante;
import com.gerenciador.condominio.repository.VisitanteRepository;

@Service
public class VisitanteService {

	@Autowired
	private VisitanteRepository repository;

	public List<Visitante> findVisitante() {
		return repository.findAll();
	}

	public Visitante find(Long id) {
		Optional<Visitante> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Visitante insert(Visitante visitante) {
		return repository.save(visitante);
	}

	// Quando id não está nulo ele atualiza
	public Visitante update(Visitante obj) {
		Visitante newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Visitante newObj, Visitante obj) {
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
