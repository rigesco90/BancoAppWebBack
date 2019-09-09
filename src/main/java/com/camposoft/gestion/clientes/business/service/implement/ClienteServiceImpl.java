package com.camposoft.gestion.clientes.business.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camposoft.gestion.clientes.business.service.IClienteService;
import com.camposoft.gestion.clientes.business.service.transformer.ClienteDto;
import com.camposoft.gestion.clientes.business.service.transformer.ClienteTransformer;
import com.camposoft.gestion.clientes.model.dao.IClienteDao;
import com.camposoft.gestion.clientes.model.dao.IPersonaDao;
import com.camposoft.gestion.clientes.model.entity.Cliente;
import com.camposoft.gestion.clientes.model.entity.Persona;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IPersonaDao personaDao;

	@Autowired
	IClienteDao clienteDao;

	@Autowired
	private ClienteTransformer transformer;

	@Override
	@Transactional(readOnly = true)
	public List<ClienteDto> listarClientes() {
		List<Persona> personas = (List<Persona>) personaDao.findAll();
		return transformarPersonaAclientes(personas);
	}

	protected List<ClienteDto> transformarPersonaAclientes(List<Persona> personas) {
		List<ClienteDto> clientes = personas.stream().map(persona -> transformer.clienteEntityAdto(persona))
				.collect(Collectors.toList());

		return clientes;
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteDto buscarClientePorIdentificacion(Integer identificacion) {
		Persona persona = personaDao.buscarPersonaPorIdentificacion(identificacion);
		ClienteDto cliente = transformer.clienteEntityAdto(persona);
		return cliente;
	}

	@Override
	@Transactional
	public ClienteDto guardar(ClienteDto cliente) {
		Persona persona = new Persona();
		persona = transformer.clienteDtoApersonaEntity(cliente);
		persona = personaDao.save(persona);
		guardarCliente(persona);
		return transformer.clienteEntityAdto(persona);
	}

	@Override
	@Transactional
	public void eliminarCliente(Integer identificacion) {
		personaDao.deleteById(identificacion);
	}

	@Override
	@Transactional
	public ClienteDto editar(ClienteDto cliente, Integer identificacion) {
		Persona personaEncontrada = personaDao.buscarPersonaPorIdentificacion(identificacion);
		personaEncontrada = personaEditadaApersonaEditar(personaEncontrada, cliente);
		Persona personaGuarda = personaDao.save(personaEncontrada);
		return transformer.clienteEntityAdto(personaGuarda);
	}

	protected Persona personaEditadaApersonaEditar(Persona personaEncontrada, ClienteDto cliente) {
		personaEncontrada.setNombres(cliente.getNombres());
		personaEncontrada.setApellidos(cliente.getApellidos());
		personaEncontrada.setCiudad(cliente.getCiudad());
		personaEncontrada.setDireccion(cliente.getDireccion());
		personaEncontrada.setTelefono(cliente.getTelefono());
		return personaEncontrada;
	}

	protected Cliente guardarCliente(Persona persona) {
		Cliente cliente = new Cliente();
		cliente.setPersona(persona);
		return clienteDao.save(cliente);
	}

}
