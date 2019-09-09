package com.camposoft.gestion.clientes.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.camposoft.gestion.clientes.model.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {
	
	@Query("SELECT P FROM Persona P JOIN FETCH P.cliente")
	public List<Persona> ListarClientes();
	
	@Query("SELECT P FROM Persona P JOIN FETCH P.cliente WHERE P.identificacion = ?1")
	public Persona buscarPersonaPorIdentificacion(Integer identificacion);

}
