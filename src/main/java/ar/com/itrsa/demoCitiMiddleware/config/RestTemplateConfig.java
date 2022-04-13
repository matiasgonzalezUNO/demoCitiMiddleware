package ar.com.itrsa.demoCitiMiddleware.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import ar.com.itrsa.demoCitiMiddleware.exception.RestTemplateResponseErrorHandler;

@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}
}
