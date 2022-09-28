package com.gerenciador.condominio.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SistemaDeGaragem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numero;
	
	@OneToOne
	private Reserva reserva;
	@OneToOne
	private Sindico sindico;
	@OneToOne
	private Condomino condomino;
	@OneToOne
	private Visitante visitante;
	
	@OneToOne
	private Acesso acesso;
	
	public SistemaDeGaragem() {
	}

	public SistemaDeGaragem(Long id, Integer numero, Reserva reserva, Sindico sindico, Condomino condomino,
			Visitante visitante) {
		super();
		this.id = id;
		this.numero = numero;
		this.reserva = reserva;
		this.sindico = sindico;
		this.condomino = condomino;
		this.visitante = visitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Sindico getSindico() {
		return sindico;
	}

	public void setSindico(Sindico sindico) {
		this.sindico = sindico;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
		
}
