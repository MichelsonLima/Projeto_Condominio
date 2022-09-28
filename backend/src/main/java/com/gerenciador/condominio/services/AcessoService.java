package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Acesso;
import com.gerenciador.condominio.repository.AcessoRepository;

@Service
public class AcessoService {

	@Autowired
	private AcessoRepository repository;

	public List<Acesso> findAcesso() {
		return repository.findAll();
	}

	public Acesso find(Long id) {
		Optional<Acesso> obj = repository.findById(id);
		return obj.orElse(null);

	}

	public Acesso insert(Acesso acesso) {
		return repository.save(acesso);
	}

	public Acesso update(Acesso obj) {
		Acesso newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Acesso newObj, Acesso obj) {
		newObj.setDataInicial(obj.getDataInicial());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

		}
	}
}
