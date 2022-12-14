package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
