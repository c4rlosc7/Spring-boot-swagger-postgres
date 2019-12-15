/**
 * 
 */
package com.carlos.reservation.persistencia.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carlos.reservation.modelo.Reserva;

/**
 * Interfaz define las operaciones de la DB relacionadas con el reserva
 * @author camar
 *
 */
public interface ReservaRepositorio extends JpaRepository<Reserva, String>{
	
	@Query("Select r from Reserva r where r.fechaIngresoReserva =: fechaInicio and r.fechaSalidaReserva =: fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaSalida") LocalDateTime fechaSalida);

}
