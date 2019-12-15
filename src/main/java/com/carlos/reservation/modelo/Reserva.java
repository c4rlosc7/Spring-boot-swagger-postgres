/**
 * 
 */
package com.carlos.reservation.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Reserva
 * @author carlos.martinez
 *
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idReserva;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaIngresoReserva;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaSalidaReserva;
	
	private int cantidadPersonasReserva;
	private String descripcionReserva;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente; // 1 - M 
}
