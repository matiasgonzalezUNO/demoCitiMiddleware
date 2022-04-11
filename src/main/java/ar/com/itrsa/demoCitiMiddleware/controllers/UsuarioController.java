package ar.com.itrsa.demoCitiMiddleware.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.itrsa.demoCitiMiddleware.models.RequestModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModel;
import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;
import ar.com.itrsa.demoCitiMiddleware.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
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
		return usuarioService.obtenerSaldo(request);
	}
	
//	@GetMapping( path = "/{id}")
//	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
//		return usuarioService.obtenerUsuarioPorId(id);
//	}
//	
//	@GetMapping( path = "/query")
//	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
//		return usuarioService.obtenerUsuarioPorPrioridad(prioridad);
//	}
//	
//	@PostMapping
//	public UsuarioModel guardarUsuario (@RequestBody UsuarioModel usuario) {
//		return this.usuarioService.guardarUsuario(usuario);
//	}
//	
//	@DeleteMapping( path = "/{id}")
//	public String eliminarPorId(@PathVariable("id") Long id) {
//		boolean ok = this.usuarioService.eliminarUsuario(id);
//		if(ok) {
//			return "Se elimino el usuario con id " + id ;
//		} else {
//			return "No se pudo eliminar el usuario con id " + id ;
//		}
//	}

}
