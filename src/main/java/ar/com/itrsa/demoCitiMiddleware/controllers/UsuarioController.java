package ar.com.itrsa.demoCitiMiddleware.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ar.com.itrsa.demoCitiMiddleware.exception.BadRequestException;
import ar.com.itrsa.demoCitiMiddleware.exception.NotFoundException;
import ar.com.itrsa.demoCitiMiddleware.exception.RestNotFoundException;
import ar.com.itrsa.demoCitiMiddleware.models.RequestModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModel;
import ar.com.itrsa.demoCitiMiddleware.services.MovimientosUserService;
import ar.com.itrsa.demoCitiMiddleware.services.UsuarioService;

//Punto de entrada de la api

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static final Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MovimientosUserService movimientosUserService;
	
	@GetMapping( path = "/getUsersDummy")
	public String obtenerUsuariosDummy() {
		return usuarioService.obtenerUsuariosDummy();
	}
	
	@GetMapping( path = "/getUsers")
	public String obtenerUsuarios() {
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping( path = "/obtenerSaldo")
	public @ResponseBody ResponseModel ObtenerSaldo(@RequestBody RequestModel request) {
		logger.info("Ingresan a transformacion del middleware");
		try {
			return usuarioService.obtenerSaldo(request);
		}
		//Este catch pertenete al Rest Template
		catch(RestNotFoundException rnfe) {
			logger.error("Ocurrio un error con la respuesta del Backend", rnfe);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, rnfe.getMessage());
		}
		catch(NotFoundException nfe) {
			logger.error("El elemento que esta buscando no existe", nfe);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, nfe.getMessage());
		}
		catch(BadRequestException bre) {
			logger.error("Los datos enviados son incorrectos", bre);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bre.getMessage());
		}
		catch(Exception e) {
			logger.error("Error general al realizar una transformacion", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general al realizar una transformacion");
		}
		
	}

	@GetMapping(value = "/movimientos/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
	    public ResponseEntity<String> list(@PathVariable("id") Integer id) {
			String list = movimientosUserService.obtenerMovimientoUser(id);
	        return new ResponseEntity<>(list, HttpStatus.OK);
	    }

}
