package ar.com.itrsa.demoCitiMiddleware.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.com.itrsa.demoCitiMiddleware.models.Movimientos;
import ar.com.itrsa.demoCitiMiddleware.models.MovimientosList;
import ar.com.itrsa.demoCitiMiddleware.models.ResponceModelOfXml;
import ar.com.itrsa.demoCitiMiddleware.models.Users;


@Service
public class MovimientosUserService {

	public ResponceModelOfXml obtenerMovimientoUser(Integer idUser){
		
		final String uri = "http://localhost:8087/homebanking/movimientos/" + idUser;
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(uri, String.class );
		
//		MovimientosList result = restTemplate.getForObject(uri, MovimientosList.class );
		
//		return result;
		
//		ResponseEntity<Movimientos[]> response =
//				  restTemplate.getForEntity(
//				  uri,
//				  Movimientos[].class);
//		
//		Movimientos[] movimientos = response.getBody();
		
		System.out.println("result de obtenerMovimientoUser" + result);
		
		JSONObject json = XML.toJSONObject(result);
		System.out.println("JSONObject json " + json);
		
		JSONObject List = (JSONObject) json.get("List");		
		System.out.println("Object List " + List);
		
		JSONArray item = List.getJSONArray("item");
		System.out.println("JSONObject item " + item);
		
//		MovimientosList movimientosList	= new MovimientosList();	
//		movimientosList.setMovimientos((java.util.List<Movimientos>) List.get("item"));
//		System.out.println("Object item " + movimientosList.toString());
		
		ResponceModelOfXml responceModelOfXml = new ResponceModelOfXml();
		Users user = new Users();
		JSONObject primerObj = item.getJSONObject(0).getJSONObject("user");
		System.out.println("primerObj " + primerObj);
		
		user.setNombre(primerObj.getString("nombre"));
		user.setNumeroDeCuenta( primerObj.getInt("numeroDeCuenta"));
		responceModelOfXml.setNombre(user.getNombre());
		responceModelOfXml.setNumeroDeCuenta(user.getNumeroDeCuenta());
		
		List<Movimientos> movList = new ArrayList<>();
		for(int i = 0; i < item.length(); i++) {
			System.out.println("for item " + i);
			JSONObject Obj = item.getJSONObject(i);
			Movimientos movimiento = new Movimientos(Obj.getString("utilDate"), Obj.getString("concepto"), Obj.getInt("importe"));
			movList.add(movimiento);
		}
		
		responceModelOfXml.setMovimientos(movList);
		
//		responceModelOfXml.setNombre(json.getString("List"));
		return responceModelOfXml;
	}
}
