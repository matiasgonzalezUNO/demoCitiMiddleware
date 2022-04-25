package ar.com.itrsa.demoCitiMiddleware.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Service
public class MovimientosUserService {
    public String obtenerMovimientoUser(Integer idUser) throws IOException {

        final String uri = "http://localhost:8087/homebanking/movimientos/" + idUser;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(result.getBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(jsonNode);

        return value;

    }



}
