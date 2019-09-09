package com.camposoft.gestion.clientes.business.service.transformer;

import java.util.List;

public class TarjetaDto {

	private String numeroTarjeta;
	private int ccv;
	private String tipoTarjeta;
	private List<ConsumoDto> consumos;

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public List<ConsumoDto> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<ConsumoDto> consumos) {
		this.consumos = consumos;
	}

}
