package ar.com.itrsa.demoCitiMiddleware.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovimientosUserService {

	public String obtenerMovimientoUser(Integer idUser){
		
		final String uri = "http://localhost:8087/homebanking/movimientos/" + idUser;
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}
}
