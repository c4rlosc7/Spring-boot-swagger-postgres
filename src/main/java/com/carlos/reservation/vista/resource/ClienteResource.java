/**
 * 
 */
package com.carlos.reservation.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.reservation.modelo.Cliente;
import com.carlos.reservation.persistencia.servicios.ClienteServicio;
import com.carlos.reservation.vista.resource.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de Cliente
 * 
 * @author carlos.martinez
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {
	private final ClienteServicio clienteServicio;

	public ClienteResource(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	@GetMapping
	@ApiOperation(value = "Lista de clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Lista de clientes correctamente"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Cliente>> obtenerClientes() {
		return ResponseEntity.ok(this.clienteServicio.obtenerClientes());
	}

	@PostMapping
	@ApiOperation(value = "Crear un cliente", notes = "Servicio para crear un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteVO clienteVo) {
		Cliente cliente = new Cliente();
		cliente.setNombreCliente(clienteVo.getNombreCliente());
		cliente.setApellidoCliente(clienteVo.getApellidoCliente());
		cliente.setIdentificacionCliente(cliente.getIdentificacionCliente());
		cliente.setDireccionCliente(clienteVo.getDireccionCliente());
		cliente.setTelefonoCliente(clienteVo.getTelefonoCliente());
		cliente.setEmailCliente(clienteVo.getEmailCliente());
		return new ResponseEntity<>(this.clienteServicio.crearCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar un cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("identificacion") String identificacion,
			@RequestBody ClienteVO clienteVo) {
		Cliente cliente = this.clienteServicio.findByIdentificacion(identificacion);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCliente(clienteVo.getNombreCliente());
			cliente.setApellidoCliente(clienteVo.getApellidoCliente());
			cliente.setIdentificacionCliente(cliente.getIdentificacionCliente());
			cliente.setDireccionCliente(clienteVo.getDireccionCliente());
			cliente.setTelefonoCliente(clienteVo.getTelefonoCliente());
			cliente.setEmailCliente(clienteVo.getEmailCliente());
		}
		return new ResponseEntity<>(this.clienteServicio.crearCliente(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar un cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void eliminarCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteServicio.findByIdentificacion(identificacion);
		if (cliente != null) {
			this.clienteServicio.eliminarCliente(cliente);
		}
	}

}
