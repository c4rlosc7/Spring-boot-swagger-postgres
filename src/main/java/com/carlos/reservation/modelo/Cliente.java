/**
 * 
 */
package com.carlos.reservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * 
 * @author carlos.martinez
 *
 */
@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query = "Select c from Cliente c where c.identificacionCliente = ?1")
public class Cliente {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String identificacionCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private String emailCliente;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas; // 1 - M

	public Cliente() {

	}
}
