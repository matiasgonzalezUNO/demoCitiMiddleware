package ar.com.itrsa.demoCitiMiddleware.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.itrsa.demoCitiMiddleware.models.RequestModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModelBack;
import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;

//import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;

@Service
public class UsuarioService {
	
	public String obtenerUsuariosDummy(){
	
		final String uri = "http://localhost:8089/usuarioBackEnd/getUsersDummy";
	
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	
	    System.out.println(result);
	    return result;
	}

	public String obtenerUsuarios(){
		
		final String uri = "http://localhost:8089/usuarioBackEnd/getUsers";
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}
	
	public ResponseModel obtenerSaldo(RequestModel request){
	
		final String uri = "http://localhost:8089/usuarioBackEnd/obtenerSaldoBack";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseModelBack result = restTemplate.postForObject(uri, request, ResponseModelBack.class);
		
		ResponseModel respuesta = new ResponseModel();
		respuesta.setSaldoActual("0,000");
        respuesta.setCode(400);
        respuesta.setStatus(false);
        respuesta.setDescripcion("Error 400: se ha producido un error inesperado");     
        
        
		if(result.getStatus()) {
        	System.out.println("usuario: "+result.getUsuarioBack());
        	respuesta.setSaldoActual(result.getUsuarioBack().getMonto().toString());
            respuesta.setCode(200);
            respuesta.setStatus(true);
            respuesta.setDescripcion("el saldo del cliente es: ");
            return respuesta;
        } else {
        	return respuesta;
        }
		
	}
//	public UsuarioModel guardarUsuario(UsuarioModel user) {
//		return usuarioRepository.save(user);
//	}
//	
//	public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
//		return usuarioRepository.findById(id);
//	}
//	
//	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad) {
//		return usuarioRepository.findByPrioridad(prioridad);
//	}
//	
//	public Boolean eliminarUsuario(Long id) {
//		try {
//			usuarioRepository.deleteById(id);
//			return true;
//		}catch(Exception err){
//			System.out.println("catch Exception err: "+ err);
//			return false;
//			
//		}
//		
//	}
}
