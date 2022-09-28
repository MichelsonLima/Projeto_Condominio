package com.gerenciador.condominio.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "condomino")
public class Condomino extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String rg;
	private String unidade;

	// Faz a referência para o conjunto de pessoas da família do condômino
	@JsonIgnore
	@OneToMany(mappedBy = "condomino", cascade=CascadeType.ALL)
	private List<Familia> familia = new ArrayList<>();

	// Faz a referência para o conjunto de visitantes do condômino
	@JsonIgnore
	@OneToMany(mappedBy = "condomino", cascade=CascadeType.ALL)
	private List<Visitante> visitante = new ArrayList<>();

	// Faz a referência para o conjunto de visitantes do condômino
	@JsonIgnore
	@OneToMany(mappedBy = "condomino", cascade=CascadeType.ALL)
	private List<PrestadorDeServico> prestadorDeServico = new ArrayList<>();
	
	@OneToOne
	private Reserva reserva;
	
	@OneToOne
	private SistemaDeGaragem sistemaDeGaragem;

	public Condomino() {
	}

	public Condomino(Long id, String nome, String endereco, String telefone, String cpf, String rg, String unidade,
			List<Familia> familia, List<Visitante> visitante, List<PrestadorDeServico> prestadorDeServico,
			Reserva reserva, SistemaDeGaragem sistemaDeGaragem) {
		super(id, nome, endereco, telefone);
		this.cpf = cpf;
		this.rg = rg;
		this.unidade = unidade;
		this.familia = familia;
		this.visitante = visitante;
		this.prestadorDeServico = prestadorDeServico;
		this.reserva = reserva;
		this.sistemaDeGaragem = sistemaDeGaragem;
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

	public void setFamilia(List<Familia> familia) {
		this.familia = familia;
	}

	public List<Visitante> getVisitante() {
		return visitante;
	}

	public void setVisitante(List<Visitante> visitante) {
		this.visitante = visitante;
	}

	public List<PrestadorDeServico> getPrestadorDeServico() {
		return prestadorDeServico;
	}

	public void setPrestadorDeServico(List<PrestadorDeServico> prestadorDeServico) {
		this.prestadorDeServico = prestadorDeServico;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public SistemaDeGaragem getSistemaDeGaragem() {
		return sistemaDeGaragem;
	}

	public void setSistemaDeGaragem(SistemaDeGaragem sistemaDeGaragem) {
		this.sistemaDeGaragem = sistemaDeGaragem;
	}
	
}
