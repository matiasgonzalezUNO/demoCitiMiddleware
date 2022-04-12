package ar.com.itrsa.demoCitiMiddleware.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.itrsa.demoCitiMiddleware.models.RequestModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModel;
import ar.com.itrsa.demoCitiMiddleware.models.ResponseModelBack;
import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;

//import ar.com.itrsa.demoCitiMiddleware.models.UsuarioModel;

@Service
public class UsuarioService {
	
	@Value("${id-tipo-doc-front}")
	private int idTipoDocFront;
	
	@Value("${id-tipo-doc-back}")
	private int idTipoDocBack;
	
	@Value("${id-LE-front}")
	private int idLeFront; 

	@Value("${id-LE-back}")
	private int idLeBack;
	
	@Value("${id-PA-front}")
	private int idPaFront;
	
	@Value("${id-PA-back}")
	private int idPaBack;
	
	@Value("${id-CI-front}")
	private int idCiFront;
	
	@Value("${id-CI-back}")
	private int idCiBack;
	
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
	
		ResponseModel respuesta = new ResponseModel();
		respuesta.setSaldoActual("0,000");
        respuesta.setCode(400);
        respuesta.setStatus(false);
        respuesta.setDescripcion("Error 400: se ha producido un error inesperado");
        Integer tipoDocRequest;
		Integer numeroDocRequest;
		
		UsuarioModel usuario = new UsuarioModel();
        
//		Validación
        if( ( String.valueOf(request.getTipoDocumento() ).equals("") || request.getTipoDocumento()==null )  ||
        		( String.valueOf(request.getNumeroDocumento() ).equals("") || request.getNumeroDocumento()==null ) )  {
        	return respuesta;
		}
        
//        Traducción via application.porpertie (simula busqueda de datos en cache para la traducción)
        tipoDocRequest = request.getTipoDocumento().intValue();
        numeroDocRequest = request.getNumeroDocumento();
        
        if(idTipoDocFront == tipoDocRequest) {      	
        	request.setTipoDocumento(idTipoDocBack); 
        	System.out.println("paso traduccion:=> numeroDocRequest:" + numeroDocRequest + "y el tipoDocReq:" + request.getTipoDocumento());
        } else if(idLeFront == tipoDocRequest) {        	
        	request.setTipoDocumento(idLeBack);
        	System.out.println("paso traduccion:=> numeroDocRequest:" + numeroDocRequest + "y el tipoDocReq:" + request.getTipoDocumento());
        } else if(idPaFront == tipoDocRequest) {     	
        	request.setTipoDocumento(idPaBack);
        	System.out.println("paso traduccion:=> numeroDocRequest:" + numeroDocRequest + "y el tipoDocReq:" + request.getTipoDocumento());
        }else if(idCiFront == tipoDocRequest) {    	
        	request.setTipoDocumento(idCiBack);
        	System.out.println("paso traduccion:=> numeroDocRequest:" + numeroDocRequest + "y el tipoDocReq:" + request.getTipoDocumento());
        }else {
        	respuesta.setDescripcion("Error 400: se ha producido un error : No paso la traduccion ");
        	return respuesta;
        }
        
		final String uri = "http://localhost:8089/usuarioBackEnd/obtenerSaldoBack";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseModelBack result = restTemplate.postForObject(uri, request, ResponseModelBack.class);          
        
//		Validación
        if( ( String.valueOf(result.getUsuarioBack() ).equals("") || result.getUsuarioBack()==null ) )  {
        	respuesta.setDescripcion("Error 400: no existe el usuario");
        	return respuesta;
		}
        
//      Traducción de datos para el response del front
		usuario = result.getUsuarioBack();      
        
        double d = usuario.getMonto();
        DecimalFormat format = new DecimalFormat("0.000");
        //Obtenemos el valor formateado
        String aux = format.format(d);
        //Reemplazamos las comas
        aux = aux.replace(".",",");
        
//      Armamos el response para el front        
		if(result.getStatus()) {
        	System.out.println("usuario: "+usuario);
        	respuesta.setSaldoActual(aux.toString());
            respuesta.setCode(200);
            respuesta.setStatus(true);
            respuesta.setDescripcion("el saldo del cliente " + usuario.getNombre() + " es: ");
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
