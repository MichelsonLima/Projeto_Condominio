package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Condomino;

@Repository
public interface CondominoRepository extends JpaRepository<Condomino, Long>{

}
