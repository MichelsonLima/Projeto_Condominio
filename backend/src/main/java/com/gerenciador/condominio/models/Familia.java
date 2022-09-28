package com.gerenciador.condominio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familia")
public class Familia extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String rg;	
	private String grauParentesco;
	
	@ManyToOne
	@JoinColumn(name = "condomino_id")	
	private Condomino condomino;
	
	public Familia() {
	}
	
	public Familia(Long id, String nome, String endereco, String telefone, String cpf, String rg, String grauParentesco,
			Condomino condomino) {
		super(id, nome, endereco, telefone);
		this.cpf = cpf;
		this.rg = rg;
		this.grauParentesco = grauParentesco;
		this.condomino = condomino;
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
