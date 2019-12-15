/**
 * 
 */
package com.carlos.reservation.vista.resource.vo;

import lombok.Data;

/**
 * @author carlos.martinez
 *
 */
@Data
public class ClienteVO {
	private String nombreCliente;
	private String apellidoCliente;
	private String identificacionCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private String emailCliente;
}
