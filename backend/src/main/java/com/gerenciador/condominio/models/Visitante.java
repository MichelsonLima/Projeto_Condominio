package com.gerenciador.condominio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "visitante")
public class Visitante extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String cpf;
	private String rg;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "condomino_id")	
	private Condomino condomino;
	
	@OneToOne
	private SistemaDeGaragem sistemaDeGaragem;
	
	@OneToOne
	private Acesso acesso;

	public Visitante() {
	}
	
	public Visitante(Long id, String nome, String endereco, String telefone, String cpf, String rg, Condomino condomino,
			SistemaDeGaragem sistemaDeGaragem, Acesso acesso) {
		super(id, nome, endereco, telefone);
		this.cpf = cpf;
		this.rg = rg;
		this.condomino = condomino;
		this.sistemaDeGaragem = sistemaDeGaragem;
		this.acesso = acesso;
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

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public SistemaDeGaragem getSistemaDeGaragem() {
		return sistemaDeGaragem;
	}

	public void setSistemaDeGaragem(SistemaDeGaragem sistemaDeGaragem) {
		this.sistemaDeGaragem = sistemaDeGaragem;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

}
