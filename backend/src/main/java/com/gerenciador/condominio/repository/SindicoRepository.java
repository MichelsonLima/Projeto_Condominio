package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Sindico;

@Repository
public interface SindicoRepository extends JpaRepository<Sindico, Long>{

}
