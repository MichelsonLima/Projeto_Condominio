package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.SistemaDeGaragem;

@Repository
public interface SistemaDeGaragemRepository extends JpaRepository<SistemaDeGaragem, Long>{

}
