package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long>{

}
