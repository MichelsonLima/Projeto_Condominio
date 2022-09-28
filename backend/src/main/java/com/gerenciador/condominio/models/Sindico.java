package com.gerenciador.condominio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sindico")
public class Sindico extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String rg;

	public Sindico() {
	}

	public Sindico(Long id, String nome, String endereco, String telefone, String cpf, String rg) {
		super(id, nome, endereco, telefone);
		this.cpf = cpf;
		this.rg = rg;
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

}
