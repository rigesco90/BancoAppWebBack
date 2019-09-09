package com.camposoft.gestion.clientes.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Asesor.findAll", query="SELECT a FROM Asesor a")
public class Asesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idasesor;

	@ManyToOne(fetch = FetchType.LAZY)
	private Especialidad especialidad;

	@OneToOne
	private Persona persona;

	public Asesor() {
	}

	public int getIdasesor() {
		return this.idasesor;
	}

	public void setIdasesor(int idasesor) {
		this.idasesor = idasesor;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}