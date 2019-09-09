package com.camposoft.gestion.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.camposoft.gestion.clientes.business.service.IClienteService;
import com.camposoft.gestion.clientes.business.service.transformer.ClienteDto;

@CrossOrigin({ "http://localhost:4200" })
@RestController()
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public List<ClienteDto> clientes() {
		return clienteService.listarClientes();
	}

	@GetMapping("/clientes/{identificacion}")
	public ClienteDto clientePorIdentificacion(@PathVariable Integer identificacion) {
		return clienteService.buscarClientePorIdentificacion(identificacion);
	}

	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto guardarCliente(@RequestBody ClienteDto cliente) {
		return clienteService.guardar(cliente);
	}

	@PutMapping("/clientes/{identificacion}")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto actualizarCliente(@RequestBody ClienteDto cliente, @PathVariable Integer identificacion) {
		return clienteService.editar(cliente, identificacion);
	}

	@DeleteMapping("/clientes/{identificacion}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarCliente(@PathVariable Integer identificacion) {
		clienteService.eliminarCliente(identificacion);
	}

}
