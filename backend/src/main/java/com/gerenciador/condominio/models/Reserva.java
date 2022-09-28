package com.gerenciador.condominio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataInicio;
	private Date dataFim;
	//private Pessoa pessoa;
	
	@OneToOne
	private Acesso acesso;
	
	@OneToOne
	private AreaComum areaComum;
	
	@OneToOne
	private Condomino condomino;
	
	@OneToOne
	private SistemaDeGaragem sistemaDeGaragem;
	
	public Reserva() {
	}

	public Reserva(Long id, Date dataInicio, Date dataFim, Acesso acesso, AreaComum areaComum, Condomino condomino,
			SistemaDeGaragem sistemaDeGaragem) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.acesso = acesso;
		this.areaComum = areaComum;
		this.condomino = condomino;
		this.sistemaDeGaragem = sistemaDeGaragem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public AreaComum getAreaComum() {
		return areaComum;
	}

	public void setAreaComum(AreaComum areaComum) {
		this.areaComum = areaComum;
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
		
}
