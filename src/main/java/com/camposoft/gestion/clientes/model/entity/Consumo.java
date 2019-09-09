package com.camposoft.gestion.clientes.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NamedQuery(name="Consumo.findAll", query="SELECT c FROM Consumo c")
public class Consumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idconsumo;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_consumo")
	private Date fechaConsumo;

	private BigDecimal monto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value="tarjeta-consumo")
	private Tarjeta tarjeta;

	public Consumo() {
	}

	public int getIdconsumo() {
		return this.idconsumo;
	}

	public void setIdconsumo(int idconsumo) {
		this.idconsumo = idconsumo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaConsumo() {
		return this.fechaConsumo;
	}

	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

}