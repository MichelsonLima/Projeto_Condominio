package com.gerenciador.condominio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataInicial;
	private Date dataFinal;
	
	@OneToOne
	private SistemaDeGaragem sistemaDeGaragem = new SistemaDeGaragem();
	@OneToOne
	private Reserva reserva;
	
	@OneToOne
	private Visitante visitante;
	
	public Acesso() {
	}

	public Acesso(Long id, Date dataInicial, Date dataFinal, SistemaDeGaragem sistemaDeGaragem, Reserva reserva,
			Visitante visitante) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.sistemaDeGaragem = sistemaDeGaragem;
		this.reserva = reserva;
		this.visitante = visitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public SistemaDeGaragem getSistemaDeGaragem() {
		return sistemaDeGaragem;
	}

	public void setSistemaDeGaragem(SistemaDeGaragem sistemaDeGaragem) {
		this.sistemaDeGaragem = sistemaDeGaragem;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
			
}
