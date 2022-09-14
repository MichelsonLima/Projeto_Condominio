package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long>{

}
