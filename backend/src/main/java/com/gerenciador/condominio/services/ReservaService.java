package com.gerenciador.condominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciador.condominio.models.Reserva;
import com.gerenciador.condominio.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository repository;

	public List<Reserva> findReserva() {
		return repository.findAll();
	}

	public Reserva find(Long id) {
		Optional<Reserva> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Reserva insert(Reserva reserva) {
		return repository.save(reserva);
	}

	// Quando id não está nulo ele atualiza
	public Reserva update(Reserva obj) {
		Reserva newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(obj);
	}

	private void updateData(Reserva newObj, Reserva obj) {
		newObj.setDataInicio(obj.getDataInicio());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

		}
	}

}
