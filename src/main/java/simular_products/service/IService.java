package simular_products.service;

import simular_products.web.model.SimilarProducts;

/**
 * Interface IService
 * @author Paul Vasile Miron
 */
public interface IService {
	/**
	 * Method that search for similar products
	 * @param productId parameter that receive the id of the user product
	 * @return SimilarProducts
	 */
	SimilarProducts getProductSimilar(String productId);

}
