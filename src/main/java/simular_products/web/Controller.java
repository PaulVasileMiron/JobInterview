package simular_products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import simular_products.service.IService;
import simular_products.web.model.SimilarProducts;

/**
 * Class Controller
 * @author Paul Vasile Miron
 */

@Slf4j
@RestController
public class Controller {
	
	@Autowired
	private IService service;

	/**
	 * Controller method that search for similar products
	 * @param productId parameter that receive the id of the user product
	 * @return SimilarProducts
	 */
	@Operation(
			summary = "Endpoint to request files to Microsoft Business Central",
			description = "Endpoint to request files to Microsoft Business Central"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "200 OK",
					content = @Content(
							schema = @Schema(implementation = SimilarProducts.class)
					)
			),
			@ApiResponse(
					responseCode = "404",
					description = "Not Product Found",
					content = @Content(
							schema = @Schema(implementation = NotFound.class)
					))
	})
    @RequestMapping(value = "/product/{productId}/similar", method = RequestMethod.GET)
	SimilarProducts getProductSimular(@PathVariable("productId") String productId) {
    	log.info("Request has been received");
        return service.getProductSimilar(productId);
    }
}
