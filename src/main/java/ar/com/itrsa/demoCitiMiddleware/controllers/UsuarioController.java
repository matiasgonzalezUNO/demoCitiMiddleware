package ar.com.itrsa.demoCitiMiddleware.controllers;

import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.com.itrsa.demoCitiMiddleware.models.RequestModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModel;
import ar.com.itrsa.demoCitiMiddleware.services.UsuarioService;
import java.util.List;
import java.util.Optional;

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

	@GetMapping( path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
		return usuarioService.obtenerUsuarioPorId(id);
	}

	@GetMapping( path = "/{prioridad}")
	public List<String> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
		return usuarioService.obtenerUsuarioPorPrioridad(prioridad);
	}

	@PostMapping
	public UsuarioModel guardarUsuario (@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}

	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Integer id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se elimino el usuario con id " + id ;
		} else {
			return "No se pudo eliminar el usuario con id " + id ;
		}
	}

}
