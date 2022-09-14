package com.gerenciador.condominio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familia")
public class Familia extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String rg;
	
	private String grauParentesco;
	
	@ManyToOne
	@JoinColumn(name = "condomino_id", nullable = false)
	private Condomino condomino;
	
	public Familia() {
	}
	
	public Familia(String nome, String endereco, String telefone, Long id, String cpf, String rg, String grauParentesco,
			Condomino condomino) {
		super(nome, endereco, telefone);
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.grauParentesco = grauParentesco;
		this.condomino = condomino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	
}
