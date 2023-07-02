package simular_products.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {
	/**
	 * Creates Springdoc object where the API Documentation is grouped by package and path
	 * pattern
	 * @return GroupedOpenApi
	 */
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
			.group("SimilarProducts")
			.packagesToScan("simular_products.web")
			.build();
	}

	/**
	 * Creates Springdoc object where it is defined or described the API definition.
	 * @return OpenAPI
	 */
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("SimilarProducts").description("API for searching similar products").version("1.0"));
	}
}
