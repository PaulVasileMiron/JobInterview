package simular_products.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import simular_products.service.IService;
import simular_products.web.model.ProductDetail;
import simular_products.web.model.SimilarProducts;

/**
 * Class Service
 * 
 * @author Paul Vasile Miron
 */
@Slf4j
@Component
public class Service implements IService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${resttemplate.endpoint}")
	private String endpoint;

	public SimilarProducts getProductSimilar(String productId) {
		List<ProductDetail> resultList = new ArrayList<>();
		SimilarProducts sp = new SimilarProducts();
		String[] strList = findSimiliarProductId(productId);

		if (strList != null && strList.length != 0) {
			log.info("Rest Template request to obtain product detail.");
			List<String> idSimilar = Arrays.asList(strList);
			idSimilar.forEach(x -> resultList.add(findProductDetail(x)));
		}
		sp.setListSimilarProduct(resultList);
		return sp;
	}

	/**
	 * Method that search for the details of one product
	 * 
	 * @param x product id
	 * @return ProductDetail
	 */
	private ProductDetail findProductDetail(String x) {
		try {
			return restTemplate.getForObject(endpoint + "/product/" + x, ProductDetail.class);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Details Not Found.");
		}
	}

	/**
	 * Method that search for id of the product that are similar
	 * 
	 * @param productId product id
	 * @return String[]
	 */
	private String[] findSimiliarProductId(String productId) {
		log.info("Rest Template request to obtain all id.");
		try {
			return restTemplate.getForObject(endpoint + "/product/" + productId + "/similarids", String[].class);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.");
		}
	}

}
