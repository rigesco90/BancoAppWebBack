package com.camposoft.gestion.clientes.business.service.transformer;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumoDto {

	private int idconsumo;
	private String descripcion;
	private Date fechaConsumo;
	private BigDecimal monto;

	public int getIdconsumo() {
		return idconsumo;
	}

	public void setIdconsumo(int idconsumo) {
		this.idconsumo = idconsumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
}
