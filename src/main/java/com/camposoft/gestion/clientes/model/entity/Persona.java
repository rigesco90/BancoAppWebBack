package com.camposoft.gestion.clientes.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int identificacion;

	private String apellidos;

	private String ciudad;

	private String direccion;

	private String nombres;

	private String telefono;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
	private Asesor asesor;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
	@JsonManagedReference(value="persona-clientes")
	private Cliente cliente;

	public Persona() {
	}

	public int getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Asesor getAsesor() {
		return this.asesor;
	}

	public void setAsesor(Asesor asesor){
		this.asesor = asesor;
	}


	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}