package simular_products.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
/**
 * Class RestTemplateConfiguration
 * @author Paul Vasile Miron
 */
@Configuration
public class RestTemplateConfiguration {

	private static final int TIMEOUT = 5000; // timeout in milliseconds

	@Bean("RestTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(TIMEOUT);
		requestFactory.setReadTimeout(TIMEOUT);

		return builder.requestFactory(() -> requestFactory).build();

	}
}
