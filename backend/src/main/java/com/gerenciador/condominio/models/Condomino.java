package com.gerenciador.condominio.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "condomino")
public class Condomino extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String rg;
	private String unidade;
	
	//Faz a referência para o conjunto de pessoas da família do condômino
	@OneToMany(mappedBy = "condomino")
	private List<Familia> familia = new ArrayList<>();
	
	//Faz a referência para o conjunto de visitantes do condômino
	@OneToMany(mappedBy = "condomino")
	private List<Visitante> visitante = new ArrayList<>();
	
	//Faz a referência para o conjunto de visitantes do condômino
	@OneToMany(mappedBy = "condomino")
	private List<PrestadorDeServico> prestadorDeServico = new ArrayList<>();
	
	public Condomino() {
	}
	
	public Condomino(String nome, String endereco, String telefone, Long id, String cpf, String rg, String unidade,
			List<Familia> familia) {
		super(nome, endereco, telefone);
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.unidade = unidade;
		this.familia = familia;
	}
	
	public Condomino(String nome, String endereco, String telefone, Long id, String cpf, String rg, String unidade,
			List<Familia> familia, List<Visitante> visitante) {
		super(nome, endereco, telefone);
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.unidade = unidade;
		this.familia = familia;
		this.visitante = visitante;
	}

	public Condomino(String nome, String endereco, String telefone, Long id, String cpf, String rg, String unidade,
			List<Familia> familia, List<Visitante> visitante, List<PrestadorDeServico> prestadorDeServico) {
		super(nome, endereco, telefone);
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.unidade = unidade;
		this.familia = familia;
		this.visitante = visitante;
		this.prestadorDeServico = prestadorDeServico;
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

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public List<Familia> getFamilia() {
		return familia;
	}

	public void addFamilia(Familia familia) {
		this.familia.add(familia);
	}
	
	public void setFamilia(List<Familia> familia) {
		this.familia = familia;
	}	
	
	public List<Visitante> getVisitante() {
		return visitante;
	}

	public void addVisitante(Visitante visitante) {
		this.visitante.add(visitante);
	}

	public List<PrestadorDeServico> getPrestadorDeServico() {
		return prestadorDeServico;
	}

	public void addPrestadorDeServico(PrestadorDeServico prestadorDeServico) {
		this.prestadorDeServico.add(prestadorDeServico);
	}	
	
}
