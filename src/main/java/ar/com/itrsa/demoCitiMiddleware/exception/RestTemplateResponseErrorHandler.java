package ar.com.itrsa.demoCitiMiddleware.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
//import ar.com.itrsa.demoCitiMiddleware.exception.NotFoundException;

//Esta clase es para poder capturar los errores que pueda llegar a tener en las llamadas de Rest Template
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		return(response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
				|| response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
		
		
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		//NOTA: Lo estoy implementando utilizando el código del error que me devuelva el BE y comparandolo para devolver el tipo
		//de error
		
		//BAD_REQUEST 
		if (response.getRawStatusCode() == 400) {
			throw new RestNotFoundException("El elemento que esta buscando no existe");
        }
		//NOT_FOUND
		else if(response.getRawStatusCode() == 404) {
        	throw new RestNotFoundException("El elemento que esta buscando no existe");
        }
		//INTERNAL_SERVER_ERROR
        else if(response.getRawStatusCode() == 500) {
        	throw new HttpClientErrorException(response.getStatusCode());
        } 
		
	}

	
}
