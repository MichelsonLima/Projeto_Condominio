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
@Table(name = "prestadorDeServicos")
public class PrestadorDeServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String endereco; 
	private String telefone;
	private String tipoServico;
	private String tipoJuridicaOuFisica;
	private String cfpOuCnpj;
	
	@ManyToOne
	@JoinColumn(name = "condomino_id")
	private Condomino condomino;
	
	public PrestadorDeServico() {
	}

	public PrestadorDeServico(Long id, String nome, String endereco, String telefone, String tipoServico,
			String tipoJuridicaOuFisica, String cfpOuCnpj, Condomino condomino) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.tipoServico = tipoServico;
		this.tipoJuridicaOuFisica = tipoJuridicaOuFisica;
		this.cfpOuCnpj = cfpOuCnpj;
		this.condomino = condomino;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getTipoJuridicaOuFisica() {
		return tipoJuridicaOuFisica;
	}

	public void setTipoJuridicaOuFisica(String tipoJuridicaOuFisica) {
		this.tipoJuridicaOuFisica = tipoJuridicaOuFisica;
	}

	public String getCfpOuCnpj() {
		return cfpOuCnpj;
	}

	public void setCfpOuCnpj(String cfpOuCnpj) {
		this.cfpOuCnpj = cfpOuCnpj;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
		
}
