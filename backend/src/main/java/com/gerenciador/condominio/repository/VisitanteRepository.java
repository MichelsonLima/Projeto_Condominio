package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long>{

}
