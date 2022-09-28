package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.PrestadorDeServico;
import com.gerenciador.condominio.repository.PrestadorDeServicoRepository;

@Service
public class PrestadorDeServicoService {

	@Autowired
	private PrestadorDeServicoRepository repository;

	public List<PrestadorDeServico> findPrestadorDeServico() {
		return repository.findAll();
	}

	public PrestadorDeServico find(Long id) {
		Optional<PrestadorDeServico> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public PrestadorDeServico insert(PrestadorDeServico prestadorDeServico) {
		return repository.save(prestadorDeServico);
	}

	// Quando id não está nulo ele atualiza
	public PrestadorDeServico update(PrestadorDeServico obj) {
		PrestadorDeServico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(PrestadorDeServico newObj, PrestadorDeServico obj) {
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
