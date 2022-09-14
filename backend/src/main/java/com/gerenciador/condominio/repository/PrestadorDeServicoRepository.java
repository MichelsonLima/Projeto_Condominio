package com.gerenciador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.condominio.models.PrestadorDeServico;

@Repository
public interface PrestadorDeServicoRepository extends JpaRepository<PrestadorDeServico, Long>{

}
