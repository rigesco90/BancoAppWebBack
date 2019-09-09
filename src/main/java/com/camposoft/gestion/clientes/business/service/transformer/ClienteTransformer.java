package com.camposoft.gestion.clientes.business.service.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.camposoft.gestion.clientes.model.entity.Consumo;
import com.camposoft.gestion.clientes.model.entity.Persona;
import com.camposoft.gestion.clientes.model.entity.Tarjeta;

@Service
public class ClienteTransformer {

	public ClienteDto clienteEntityAdto(Persona persona) {
		ClienteDto clienteDto = new ClienteDto();
		List<TarjetaDto> tarjetasDto = new ArrayList<TarjetaDto>();
		if (persona != null) {
			if (persona.getCliente() != null && persona.getCliente().getTarjetas() != null) {

				List<Tarjeta> tarjetas = persona.getCliente().getTarjetas();
				tarjetasDto = convertirTarjetasEntityAdto(tarjetas);
			}

			clienteDto.setIdentificacion(persona.getIdentificacion());
			clienteDto.setNombres(persona.getNombres());
			clienteDto.setApellidos(persona.getApellidos());
			clienteDto.setCiudad(persona.getCiudad());
			clienteDto.setDireccion(persona.getDireccion());
			clienteDto.setTarjetas(tarjetasDto);
			clienteDto.setTelefono(persona.getTelefono());
		}
		return clienteDto;
	}

	protected List<TarjetaDto> convertirTarjetasEntityAdto(List<Tarjeta> tarjetas) {

		return tarjetas.stream().map(tarjeta -> {
			List<Consumo> consumos = new ArrayList<Consumo>();
			if (tarjeta.getConsumos() != null) {
				consumos = tarjeta.getConsumos();
			}
			List<ConsumoDto> consumosDto = convertirConsumosEntityAdto(consumos);
			TarjetaDto tarjetaDto = new TarjetaDto();
			tarjetaDto.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
			tarjetaDto.setCcv(tarjeta.getCcv());
			tarjetaDto.setTipoTarjeta(tarjeta.getTipoTarjeta());
			tarjetaDto.setConsumos(consumosDto);

			return tarjetaDto;

		}).collect(Collectors.toList());
	}

	protected List<ConsumoDto> convertirConsumosEntityAdto(List<Consumo> consumos) {
		return consumos.stream().map(consumo -> {
			ConsumoDto consumoDto = new ConsumoDto();

			consumoDto.setDescripcion(consumo.getDescripcion());
			consumoDto.setFechaConsumo(consumo.getFechaConsumo());
			consumoDto.setMonto(consumo.getMonto());

			return consumoDto;

		}).collect(Collectors.toList());
	}

	public Persona clienteDtoApersonaEntity(ClienteDto cliente) {
		Persona persona = new Persona();
		persona.setIdentificacion(cliente.getIdentificacion());
		persona.setNombres(cliente.getNombres());
		persona.setApellidos(cliente.getApellidos());
		persona.setCiudad(cliente.getCiudad());
		persona.setDireccion(cliente.getDireccion());
		persona.setTelefono(cliente.getTelefono());
		return persona;
	}

}
