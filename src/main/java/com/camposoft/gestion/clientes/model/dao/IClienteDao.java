package com.camposoft.gestion.clientes.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.camposoft.gestion.clientes.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

}
