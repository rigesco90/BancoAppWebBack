package com.camposoft.gestion.clientes.business.service.transformer;

import java.util.List;

public class ClienteDto {

	private int identificacion;
	private String apellidos;
	private String ciudad;
	private String direccion;
	private String nombres;
	private String telefono;
	private List<TarjetaDto> tarjetas;

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TarjetaDto> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaDto> tarjetas) {
		this.tarjetas = tarjetas;
	}
}
