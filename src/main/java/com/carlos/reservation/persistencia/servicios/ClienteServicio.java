/**
 * 
 */
package com.carlos.reservation.persistencia.servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.reservation.modelo.Cliente;
import com.carlos.reservation.persistencia.repositorio.ClienteRepositorio;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author camar
 *
 */
@Service
@Transactional(readOnly = true)
public class ClienteServicio {

	private final ClienteRepositorio clienteRepositorio;

	// Constructor
	public ClienteServicio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}

	/**
	 * Método que me permite CREAR un cliente en la DB
	 * 
	 * @param cliente
	 * @return cliente
	 */
	@Transactional
	public Cliente crearCliente(Cliente cliente) {
		return this.clienteRepositorio.save(cliente);
	}

	/**
	 * Método que me permite ACTUALIZAR un cliente en la DB
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente actualizarCliente(Cliente cliente) {
		return this.clienteRepositorio.save(cliente);
	}

	/**
	 * Método que me permite ELIMINAR un cliente de la DB
	 * 
	 * @param cliente
	 */
	@Transactional
	public void eliminarCliente(Cliente cliente) {
		this.clienteRepositorio.delete(cliente);
	}
	
	/**
	 * Método que me permite OBTENER todos los clientes de la DB
	 * @return
	 */
	public List<Cliente> obtenerClientes() {
		return this.clienteRepositorio.findAll();
	}
	
	/**
	 * Método que me permite OBTENER un cliente de la DB
	 * @param cliente
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacion) {
		return this.clienteRepositorio.findByIdentificacion(identificacion);
	}

}
