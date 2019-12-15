/**
 * 
 */
package com.carlos.reservation.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.reservation.modelo.Cliente;

/**
 * Interfaz define las operaciones de la DB relacionadas con el cliente
 * @author camar
 *
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
	
	/**
	 * Definición del metodo que obtiene lista de clientes por apellido
	 * @param apellidoCliente
	 * @return
	 */
	public List<Cliente> findByApellidoCliente(String apellidoCliente);
	
	/**
	 * Definición del metodo que obtiene cliente por su identificación
	 * @param identificacionCliente
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCliente);

}
