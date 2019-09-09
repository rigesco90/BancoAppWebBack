package com.camposoft.gestion.clientes.business.service;

import java.util.List;

import com.camposoft.gestion.clientes.business.service.transformer.ClienteDto;

public interface IClienteService {
	
	public List<ClienteDto> listarClientes();
	
	public ClienteDto buscarClientePorIdentificacion(Integer identificacion);
	
	public ClienteDto guardar(ClienteDto cliente);
	
	public ClienteDto editar(ClienteDto cliente, Integer identificacion);
	
	public void eliminarCliente(Integer identificacion);

}
